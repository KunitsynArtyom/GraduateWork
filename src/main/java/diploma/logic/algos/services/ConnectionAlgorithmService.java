package diploma.logic.algos.services;

import diploma.logic.algos.entities.*;
import diploma.logic.entities.*;
import diploma.logic.repositories.ConnectionObjectJoinRepo;
import diploma.logic.repositories.ObjRepo;
import diploma.logic.repositories.ObjectInstanceListRepo;
import diploma.logic.repositories.ObjectInstanceRepo;
import org.springframework.context.ApplicationContext;

import java.util.*;

/**
 * Created by Артём on 18.05.2017.
 */
public class ConnectionAlgorithmService {

    public Set<AlgoConnection> createConnection(Map<Obj, List<ObjectInstance>> objMap) throws Exception {

        if (objMap.size() % 2 != 0) {
            throw new Exception("Incorrect input data!");
        }

        Map<Obj, List<AlgoObjInstance>> objListMap = new LinkedHashMap<Obj, List<AlgoObjInstance>>();
        List<AlgoObj> algoObjList = new ArrayList<AlgoObj>();

        for (Map.Entry entry : objMap.entrySet()) {
            objListMap.put((Obj) entry.getKey(), convertObjInstanceListToAlgoObjInstance((List<ObjectInstance>) entry.getValue()));
        }

        for (Map.Entry entry : objListMap.entrySet()) {
            algoObjList.add(convertObjToAlgoObj((Obj) entry.getKey(), (List<AlgoObjInstance>) entry.getValue()));
        }

        return convertAlgoObjListToAlgoConnection(algoObjList);
    }

    private List<AlgoObjInstance> convertObjInstanceListToAlgoObjInstance(List<ObjectInstance> objectInstanceList) {
        List<AlgoObjInstance> algoObjInstanceList = new ArrayList<AlgoObjInstance>();

        for (ObjectInstance objectInstance : objectInstanceList) {
            algoObjInstanceList.add(new AlgoObjInstance(objectInstance.getName()));
        }

        return algoObjInstanceList;
    }

    private AlgoObj convertObjToAlgoObj(Obj obj, List<AlgoObjInstance> algoObjInstanceList) {

        return new AlgoObj(obj.getName(), algoObjInstanceList);
    }

    private Set<AlgoConnection> convertAlgoObjListToAlgoConnection(List<AlgoObj> algoObjList) {
        Set<AlgoConnection> algoConnectionSet = new LinkedHashSet<AlgoConnection>();

        for (int i = 0; i < algoObjList.size(); i += 2) {
            algoConnectionSet.add(new AlgoConnection(algoObjList.get(i), algoObjList.get(i + 1)));
        }

        return algoConnectionSet;
    }

    public Set<AlgoConnection> getAlgoConnectionList(ApplicationContext context, List<Connection> connections) throws Exception {
        ObjectInstanceRepo objectInstanceRepo = context.getBean(ObjectInstanceRepo.class);
        ObjRepo objRepo = context.getBean(ObjRepo.class);
        ConnectionObjectJoinRepo connectionObjectJoinRepo = context.getBean(ConnectionObjectJoinRepo.class);

        List<List<ConnectionObjectJoin>> connectionObjectJoinLists = new ArrayList<>();
        Map<Obj, List<ObjectInstance>> objMap = new LinkedHashMap<Obj, List<ObjectInstance>>();

        Set<AlgoConnection> algoConnectionList = null;

        try {
            for (Connection connection : connections) {
                connectionObjectJoinLists.add(new ArrayList(connectionObjectJoinRepo.findByConnId(connection.getId())));
            }

            for (List<ConnectionObjectJoin> list : connectionObjectJoinLists) {
                for (ConnectionObjectJoin connectionObjectJoin : list) {
                    List<Obj> objList = new ArrayList<Obj>();
                    objList.add(objRepo.findById(connectionObjectJoin.getObjectId()));
                    for (Obj obj : objList) {
                        objMap.put(obj, objectInstanceRepo.findByObjId(obj.getId()));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Exception("Errors while getting connectionList!");
        }

        algoConnectionList = createConnection(objMap);

        return algoConnectionList;
    }

    public List<List<AlgoConnectionInstance>> getAlgoConnectionInstanceList(ApplicationContext context, List<Integer> distinctSDList, List<ConnectionStateInstance> connectionStateInstanceList) throws Exception {
        ObjectInstanceRepo objectInstanceRepo = context.getBean(ObjectInstanceRepo.class);
        ObjectInstanceListRepo objectInstanceListRepo = context.getBean(ObjectInstanceListRepo.class);

        Map<Integer, List<AlgoConnectionInstance>> groupedByStateConnectionInstanceMap = new LinkedHashMap<Integer, List<AlgoConnectionInstance>>();
        List<List<AlgoConnectionInstance>> connectionInstanceList = new ArrayList<List<AlgoConnectionInstance>>();

        try {
            for (Integer integer : distinctSDList) {
                List<AlgoConnectionInstance> temporaryList = new ArrayList<AlgoConnectionInstance>();

                for (ConnectionStateInstance connectionStateInstance : connectionStateInstanceList) {
                    if (integer == connectionStateInstance.getConnectionStateId()) {
                        List<ObjectInstanceList> tempObjectInstanceLists = objectInstanceListRepo.findObjectInstanceListByConnectionInstance(connectionStateInstance.getConnectionInstanceId());
                        List<ObjectInstance> tempObjectInstanceList = new ArrayList<ObjectInstance>();

                        for (ObjectInstanceList objectInstanceList : tempObjectInstanceLists) {
                            tempObjectInstanceList.add(objectInstanceRepo.findById(objectInstanceList.getObjectInstanceId()));
                        }

                        temporaryList.add(new AlgoConnectionInstance(tempObjectInstanceList.get(0).getName(), tempObjectInstanceList.get(1).getName()));

                    }
                }
                groupedByStateConnectionInstanceMap.put(integer, temporaryList);
            }

            for (Map.Entry entry : groupedByStateConnectionInstanceMap.entrySet()) {
                connectionInstanceList.add((List<AlgoConnectionInstance>) entry.getValue());
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Exception("Errors while getting the connection instance list!");
        }

        return connectionInstanceList;
    }
}
