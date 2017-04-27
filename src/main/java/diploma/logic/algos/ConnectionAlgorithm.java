package diploma.logic.algos;

import diploma.logic.algos.entities.*;

import java.util.*;

/**
 * Created by Артём on 09.04.2017.
 */
public class ConnectionAlgorithm {

    private Set<Connection> connectionSet;
    private List<List<ConnectionInstance>> connectionInstanceLists;
    private List<MassProblem> massProblemList;
    private Map<Connection, Set<ConnectionInstance>> groupedConnectionInstances;
    private Map<Connection, Double> stability;
    private Map<Connection, Double> inevitability;
    private Map<MassProblem, List<List<ConnectionInstance>>> groupedMassProblems;
    private Map<MassProblem, Map<Connection, Set<ConnectionInstance>>> groupedMassProblemsConnections;
    private HashMap<MassProblem, Map<Connection, Double>> createProbability;
    private HashMap<MassProblem, Map<Connection, Double>> destroyProbability;

    public ConnectionAlgorithm(){
        connectionSet = new HashSet<Connection>();
        connectionInstanceLists = new ArrayList<List<ConnectionInstance>>();
        groupedConnectionInstances = new HashMap<Connection, Set<ConnectionInstance>>();
        stability = new HashMap<Connection, Double>();
        inevitability = new HashMap<Connection, Double>();
        massProblemList = new ArrayList<MassProblem>();
        groupedMassProblems = new HashMap<MassProblem, List<List<ConnectionInstance>>>();
        groupedMassProblemsConnections = new HashMap<MassProblem, Map<Connection, Set<ConnectionInstance>>>();
        createProbability = new HashMap<MassProblem, Map<Connection, Double>>();
        destroyProbability = new HashMap<MassProblem, Map<Connection, Double>>();
    }

    public void calculate(Set<Connection> connectionSet,
                          List<List<ConnectionInstance>> connectionInstanceSet,
                          List<MassProblem> massProblemList){
        this.connectionSet = connectionSet;
        this.connectionInstanceLists = connectionInstanceSet;
        this.massProblemList = massProblemList;

        groupByConnection();
        calculateStability();
        calculateInevitability();
        calculateMassProblemsScales();
        showStat();
    }

    private void groupByConnection(){
        for(Connection connection : connectionSet){
            groupedConnectionInstances.put(connection, findByConnection(connection));
        }
    }

    private Set<ConnectionInstance> findByConnection(Connection connection){
        Set<ConnectionInstance> groupedConnectionInstanceSet = new HashSet<ConnectionInstance>();

        for(List<ConnectionInstance> list : connectionInstanceLists) {
            for (ConnectionInstance connectionInstance : list) {
                if (connection.getObj1().getObjectInstanceList().contains(new ObjInstance(connectionInstance.getField1())) &&
                        connection.getObj2().getObjectInstanceList().contains(new ObjInstance(connectionInstance.getField2()))) {
                    groupedConnectionInstanceSet.add(connectionInstance);
                }
            }
        }

        return groupedConnectionInstanceSet;
    }

    private void calculateStability(){
        Set<ConnectionInstance> connectionInstanceSet;
        for(Map.Entry entry : groupedConnectionInstances.entrySet()){
            int n = 0, m = 0;
            connectionInstanceSet = (Set)entry.getValue();

            for(ConnectionInstance connectionInstance : connectionInstanceSet){
                n += findRepeatsByConnectionInstance(connectionInstance);
                m += findLinkedRepeatsByConnectionInstance(connectionInstance);
            }

            stability.put((Connection)entry.getKey(), (double)m/n);
        }
    }

    private void calculateInevitability(){
        Set<ConnectionInstance> connectionInstanceSet;
        for(Map.Entry entry : groupedConnectionInstances.entrySet()){
            int n = 0, m = 0;
            connectionInstanceSet = (Set)entry.getValue();

            for(ConnectionInstance connectionInstance : connectionInstanceSet){
                n += findRepeatsByConnectionInstance(connectionInstance);
                m += findEmergenceByConnectionInstance(connectionInstance);
            }

            inevitability.put((Connection)entry.getKey(), (double)m/n);
        }
    }

    private int findRepeatsByConnectionInstance(ConnectionInstance connectionInstance){
        int n = 0;

        for(List<ConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                n++;
            }
        }

        return n;
    }

    private int findLinkedRepeatsByConnectionInstance(ConnectionInstance connectionInstance){
        int m = 0;
        boolean repeatFlag = false;

        for(List<ConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                if(repeatFlag){
                    m++;
                }
                repeatFlag = true;
            } else repeatFlag = false;
        }

        return m;
    }

    private int findEmergenceByConnectionInstance(ConnectionInstance connectionInstance){
        int m = 0;
        boolean repeatFlag = false;

        for(List<ConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                if(!repeatFlag){
                    m++;
                }
                repeatFlag = true;
            } else repeatFlag = false;
        }

        return m;
    }

    private void showStat(){
        System.out.println("Stability");
        for(Map.Entry entry : stability.entrySet()){
            System.out.println("Key: " + "'" + entry.getKey() + "'"  + " Value: " + "'" + entry.getValue() + "'");
        }

        System.out.println("Inevitability");
        for(Map.Entry entry : inevitability.entrySet()){
            System.out.println("Key: " + "'" + entry.getKey() + "'"  + " Value: " + "'" + entry.getValue() + "'");
        }

        System.out.println("Mass Problems");
        for(Map.Entry entry : groupedMassProblemsConnections.entrySet()){
            System.out.println(entry.getKey());
            Map<Connection, Set<ConnectionInstance>> temporaryMap = (Map<Connection, Set<ConnectionInstance>>)entry.getValue();

            for(Map.Entry innerEntry : temporaryMap.entrySet()){
                System.out.println("Key: " + "'" + innerEntry.getKey() + "'"  + " Value: " + "'" + innerEntry.getValue() + "'");
            }

            System.out.println("groupedMassProblems");
            for(Map.Entry entryMap : groupedMassProblems.entrySet()){
                System.out.println(entryMap.getKey());
                System.out.println(entryMap.getValue());
            }

            System.out.println("groupedMassProblemsConnections");
            for(Map.Entry entryMap : groupedMassProblemsConnections.entrySet()){
                System.out.println(entryMap.getKey());
                System.out.println(entryMap.getValue());
            }

            System.out.println("Create Probability");
            for(Map.Entry createProbEntry : createProbability.entrySet()){
                System.out.println("Key: " + "'" + createProbEntry.getKey() + "'"  + " Value: " + "'" + createProbEntry.getValue() + "'");
            }

            System.out.println("Destroy Probability");
            for(Map.Entry destroyProbEntry : destroyProbability.entrySet()){
                System.out.println("Key: " + "'" + destroyProbEntry.getKey() + "'"  + " Value: " + "'" + destroyProbEntry.getValue() + "'");
            }
        }
    }




    public void calculateMassProblemsScales(){
        groupConnectionInstancesByMassProblems();
        groupConnectionsByMassProblems();
        calculateCreateProbability();
    }

    private void groupConnectionInstancesByMassProblems(){
        for(MassProblem massProblem : massProblemList){
            groupedMassProblems.put(massProblem, getConnectionInstancePairList(massProblem));
        }
    }

    private void groupConnectionsByMassProblems(){
        for(MassProblem massProblem : massProblemList){
            groupedMassProblemsConnections.put(massProblem, groupMassProblemConnectionInstancesByConnection(massProblem));
        }
    }

    private List<List<ConnectionInstance>> getConnectionInstancePairList(MassProblem massProblem){
        List<List<ConnectionInstance>> massProblemConnectionInstanceList = new ArrayList<List<ConnectionInstance>>();

        for(int i = 0; i < massProblemList.size(); i++){
            if(massProblemList.get(i) == massProblem){
                massProblemConnectionInstanceList.add(connectionInstanceLists.get(i));
                massProblemConnectionInstanceList.add(connectionInstanceLists.get(i + 1));
            }
        }

        return massProblemConnectionInstanceList;
    }

    private Map<Connection, Set<ConnectionInstance>> groupMassProblemConnectionInstancesByConnection(MassProblem massProblem){
        Map<Connection, Set<ConnectionInstance>> groupedMassProblemConnectionInstances = new HashMap<Connection, Set<ConnectionInstance>>();

        for(Map.Entry entry : groupedMassProblems.entrySet()){
            if(entry.getKey() == massProblem){
                for(Connection connection : connectionSet){
                    groupedMassProblemConnectionInstances.put(connection, findByConnection(connection, (List<List<ConnectionInstance>>)entry.getValue()));
                }
            }
        }

        return groupedMassProblemConnectionInstances;
    }

    private Set<ConnectionInstance> findByConnection(Connection connection, List<List<ConnectionInstance>> massProblemConnectionInstancesList){
        Set<ConnectionInstance> connectionInstances = new HashSet<ConnectionInstance>();

        for(List<ConnectionInstance> list : massProblemConnectionInstancesList){
            for(ConnectionInstance connectionInstance : list){
                if (connection.getObj1().getObjectInstanceList().contains(new ObjInstance(connectionInstance.getField1())) &&
                        connection.getObj2().getObjectInstanceList().contains(new ObjInstance(connectionInstance.getField2()))) {
                    connectionInstances.add(connectionInstance);
                }
            }
        }

        return connectionInstances;
    }

    public Map<MassProblem, Map<Connection, Double>> getCreateProbability(){
        return createProbability;
    }

    private void calculateCreateProbability(){
        Map<Connection, Set<ConnectionInstance>> groupedConnectionInstanceMap;

        for(Map.Entry entry : groupedMassProblemsConnections.entrySet()){
            groupedConnectionInstanceMap = (Map<Connection, Set<ConnectionInstance>>)entry.getValue();
            List<List<ConnectionInstance>> connInstanceLists = groupedMassProblems.get(entry.getKey());
            createProbability.put((MassProblem)entry.getKey(), calculateMassProblemCreateProbability(connInstanceLists, groupedConnectionInstanceMap));
            destroyProbability.put((MassProblem)entry.getKey(), calculateMassProblemDestroyProbability(connInstanceLists, groupedConnectionInstanceMap));
        }
    }

    private Map<Connection, Double> calculateMassProblemCreateProbability(List<List<ConnectionInstance>> connInstanceLists,
                                                                          Map<Connection, Set<ConnectionInstance>>  connConnectionInstanceSet){
        Map<Connection, Double> connectionValueMap = new HashMap<Connection, Double>();

        for(Map.Entry entry : connConnectionInstanceSet.entrySet()){
            int j = 0, k = 0;
            for(ConnectionInstance connInstance : (Set<ConnectionInstance>)entry.getValue()){
                int m = 0, n = 0;
                boolean repeatFlag = false;
                for(int i = 0; i < connInstanceLists.size(); i++){
                    if(connInstanceLists.get(i).contains(connInstance)){
                        if(!repeatFlag){
                            if(i != 0){
                                m++;
                            }
                        }
                        repeatFlag = true;
                    } else repeatFlag = false;
                    n++;
                }
                j += m;
                k += n;
            }

            connectionValueMap.put((Connection)entry.getKey(), (double)j/k);
        }

        return connectionValueMap;
    }

    private Map<Connection, Double> calculateMassProblemDestroyProbability(List<List<ConnectionInstance>> connInstanceLists,
                                                                           Map<Connection, Set<ConnectionInstance>>  connConnectionInstanceSet) {
        Map<Connection, Double> connectionValueMap = new HashMap<Connection, Double>();

        for(Map.Entry entry : connConnectionInstanceSet.entrySet()){
            int j = 0, k = 0;
            for(ConnectionInstance connInstance : (Set<ConnectionInstance>)entry.getValue()){
                int m = 0, n = 0;
                boolean repeatFlag = false;
                for(int i = 0; i < connInstanceLists.size(); i++){
                    if(connInstanceLists.get(i).contains(connInstance)){
                        repeatFlag = true;
                    } else {
                        if(repeatFlag){
                            if(i != 0){
                                m++;
                            }
                            repeatFlag = false;
                        }
                    }
                    n++;
                }
                j += m;
                k += n;
            }

            connectionValueMap.put((Connection)entry.getKey(), (double)j/k);
        }

        return connectionValueMap;
    }
}
