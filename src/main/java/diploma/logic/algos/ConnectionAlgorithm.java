package diploma.logic.algos;

import diploma.logic.algos.entities.*;

import java.util.*;

/**
 * Created by Артём on 09.04.2017.
 */
public class ConnectionAlgorithm {

    private Set<AlgoConnection> connectionSet;
    private List<List<AlgoConnectionInstance>> connectionInstanceLists;
    private List<AlgoMassProblem> massProblemList;
    private Map<AlgoConnection, Set<AlgoConnectionInstance>> groupedConnectionInstances;
    private Map<AlgoConnection, Double> stability, inevitability;
    private Map<AlgoMassProblem, List<List<AlgoConnectionInstance>>> groupedMassProblems;
    private Map<AlgoMassProblem, Map<AlgoConnection, Set<AlgoConnectionInstance>>> groupedMassProblemsConnections;
    private Map<AlgoMassProblem, Map<AlgoConnection, Double>> createProbability, destroyProbability;

    public ConnectionAlgorithm(){
        connectionSet = new LinkedHashSet<AlgoConnection>();
        connectionInstanceLists = new ArrayList<List<AlgoConnectionInstance>>();
        groupedConnectionInstances = new LinkedHashMap<AlgoConnection, Set<AlgoConnectionInstance>>();
        stability = new LinkedHashMap<AlgoConnection, Double>();
        inevitability = new LinkedHashMap<AlgoConnection, Double>();
        massProblemList = new ArrayList<AlgoMassProblem>();
        groupedMassProblems = new LinkedHashMap<AlgoMassProblem, List<List<AlgoConnectionInstance>>>();
        groupedMassProblemsConnections = new LinkedHashMap<AlgoMassProblem, Map<AlgoConnection, Set<AlgoConnectionInstance>>>();
        createProbability = new LinkedHashMap<AlgoMassProblem, Map<AlgoConnection, Double>>();
        destroyProbability = new LinkedHashMap<AlgoMassProblem, Map<AlgoConnection, Double>>();
    }

    public void calculate(Set<AlgoConnection> connectionSet,
                          List<List<AlgoConnectionInstance>> connectionInstanceLists,
                          List<AlgoMassProblem> massProblemList){
        this.connectionSet = connectionSet;
        this.connectionInstanceLists = connectionInstanceLists;
        this.massProblemList = massProblemList;

        groupByConnection();
        calculateStability();
        calculateInevitability();
        calculateMassProblemsScales();
        showStat();
    }

    private void groupByConnection(){
        for(AlgoConnection connection : connectionSet){
            groupedConnectionInstances.put(connection, findByConnection(connection));
        }
    }

    private Set<AlgoConnectionInstance> findByConnection(AlgoConnection connection){
        Set<AlgoConnectionInstance> groupedConnectionInstanceSet = new LinkedHashSet<AlgoConnectionInstance>();

        for(List<AlgoConnectionInstance> list : connectionInstanceLists) {
            for (AlgoConnectionInstance connectionInstance : list) {
                if (connection.getObj1().getObjectInstanceList().contains(new AlgoObjInstance(connectionInstance.getField1())) &&
                        connection.getObj2().getObjectInstanceList().contains(new AlgoObjInstance(connectionInstance.getField2()))) {
                    groupedConnectionInstanceSet.add(connectionInstance);
                }
            }
        }

        return groupedConnectionInstanceSet;
    }

    private void calculateStability(){
        Set<AlgoConnectionInstance> connectionInstanceSet;
        for(Map.Entry entry : groupedConnectionInstances.entrySet()){
            int n = 0, m = 0;
            connectionInstanceSet = (Set)entry.getValue();

            for(AlgoConnectionInstance connectionInstance : connectionInstanceSet){
                n += findRepeatsByConnectionInstance(connectionInstance);
                m += findLinkedRepeatsByConnectionInstance(connectionInstance);
            }

            stability.put((AlgoConnection)entry.getKey(), (double)m/n);
        }
    }

    private void calculateInevitability(){
        Set<AlgoConnectionInstance> connectionInstanceSet;
        for(Map.Entry entry : groupedConnectionInstances.entrySet()){
            int n = 0, m = 0;
            connectionInstanceSet = (Set)entry.getValue();

            for(AlgoConnectionInstance connectionInstance : connectionInstanceSet){
                n += findRepeatsByConnectionInstance(connectionInstance);
                m += findEmergenceByConnectionInstance(connectionInstance);
            }

            inevitability.put((AlgoConnection)entry.getKey(), (double)m/n);
        }
    }

    private int findRepeatsByConnectionInstance(AlgoConnectionInstance connectionInstance){
        int n = 0;

        for(List<AlgoConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                n++;
            }
        }

        return n;
    }

    private int findLinkedRepeatsByConnectionInstance(AlgoConnectionInstance connectionInstance){
        int m = 0;
        boolean repeatFlag = false;

        for(List<AlgoConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                if(repeatFlag){
                    m++;
                }
                repeatFlag = true;
            } else repeatFlag = false;
        }

        return m;
    }

    private int findEmergenceByConnectionInstance(AlgoConnectionInstance connectionInstance){
        int m = 0;
        boolean repeatFlag = false;

        for(List<AlgoConnectionInstance> list : connectionInstanceLists){
            if(list.contains(connectionInstance)){
                if(!repeatFlag){
                    m++;
                }
                repeatFlag = true;
            } else repeatFlag = false;
        }

        return m;
    }

    public void calculateMassProblemsScales(){
        groupConnectionInstancesByMassProblems();
        groupConnectionsByMassProblems();
        calculateCreateDestroyProbability();
    }

    private void groupConnectionInstancesByMassProblems(){
        for(AlgoMassProblem massProblem : massProblemList){
            groupedMassProblems.put(massProblem, getConnectionInstancePairList(massProblem));
        }
    }

    private void groupConnectionsByMassProblems(){
        for(AlgoMassProblem massProblem : massProblemList){
            groupedMassProblemsConnections.put(massProblem, groupMassProblemConnectionInstancesByConnection(massProblem));
        }
    }

    private List<List<AlgoConnectionInstance>> getConnectionInstancePairList(AlgoMassProblem massProblem){
        List<List<AlgoConnectionInstance>> massProblemConnectionInstanceList = new ArrayList<List<AlgoConnectionInstance>>();

        for(int i = 0; i < massProblemList.size(); i++){
            if(massProblemList.get(i).equals(massProblem)){
                massProblemConnectionInstanceList.add(connectionInstanceLists.get(i));
                massProblemConnectionInstanceList.add(connectionInstanceLists.get(i + 1));
            }
        }

        return massProblemConnectionInstanceList;
    }

    private Map<AlgoConnection, Set<AlgoConnectionInstance>> groupMassProblemConnectionInstancesByConnection(AlgoMassProblem massProblem){
        Map<AlgoConnection, Set<AlgoConnectionInstance>> groupedMassProblemConnectionInstances = new LinkedHashMap<AlgoConnection, Set<AlgoConnectionInstance>>();

        for(Map.Entry entry : groupedMassProblems.entrySet()){
            if(entry.getKey().equals(massProblem)){
                for(AlgoConnection connection : connectionSet){
                    groupedMassProblemConnectionInstances.put(connection, findByConnection(connection, (List<List<AlgoConnectionInstance>>)entry.getValue()));
                }
            }
        }

        return groupedMassProblemConnectionInstances;
    }

    private Set<AlgoConnectionInstance> findByConnection(AlgoConnection connection, List<List<AlgoConnectionInstance>> massProblemConnectionInstancesList){
        Set<AlgoConnectionInstance> connectionInstances = new LinkedHashSet<AlgoConnectionInstance>();

        for(List<AlgoConnectionInstance> list : massProblemConnectionInstancesList){
            for(AlgoConnectionInstance connectionInstance : list){
                if (connection.getObj1().getObjectInstanceList().contains(new AlgoObjInstance(connectionInstance.getField1())) &&
                        connection.getObj2().getObjectInstanceList().contains(new AlgoObjInstance(connectionInstance.getField2()))) {
                    connectionInstances.add(connectionInstance);
                }
            }
        }

        return connectionInstances;
    }

    private void calculateCreateDestroyProbability(){
        Map<AlgoConnection, Set<AlgoConnectionInstance>> groupedConnectionInstanceMap;

        for(Map.Entry entry : groupedMassProblemsConnections.entrySet()){
            groupedConnectionInstanceMap = (Map<AlgoConnection, Set<AlgoConnectionInstance>>)entry.getValue();
            List<List<AlgoConnectionInstance>> connInstanceLists = groupedMassProblems.get(entry.getKey());
            createProbability.put((AlgoMassProblem)entry.getKey(), calculateMassProblemCreateProbability(connInstanceLists, groupedConnectionInstanceMap));
            destroyProbability.put((AlgoMassProblem)entry.getKey(), calculateMassProblemDestroyProbability(connInstanceLists, groupedConnectionInstanceMap));
        }
    }

    private Map<AlgoConnection, Double> calculateMassProblemCreateProbability(List<List<AlgoConnectionInstance>> connInstanceLists,
                                                                              Map<AlgoConnection, Set<AlgoConnectionInstance>>  connConnectionInstanceSet){
        Map<AlgoConnection, Double> connectionValueMap = new LinkedHashMap<AlgoConnection, Double>();

        for(Map.Entry entry : connConnectionInstanceSet.entrySet()){
            int j = 0, k = 0;
            for(AlgoConnectionInstance connInstance : (Set<AlgoConnectionInstance>)entry.getValue()){
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

            connectionValueMap.put((AlgoConnection)entry.getKey(), (double)j/k);
        }

        return connectionValueMap;
    }

    private Map<AlgoConnection, Double> calculateMassProblemDestroyProbability(List<List<AlgoConnectionInstance>> connInstanceLists,
                                                                               Map<AlgoConnection, Set<AlgoConnectionInstance>>  connConnectionInstanceSet) {
        Map<AlgoConnection, Double> connectionValueMap = new LinkedHashMap<AlgoConnection, Double>();

        for(Map.Entry entry : connConnectionInstanceSet.entrySet()){
            int j = 0, k = 0;
            for(AlgoConnectionInstance connInstance : (Set<AlgoConnectionInstance>)entry.getValue()){
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

            connectionValueMap.put((AlgoConnection)entry.getKey(), (double)j/k);
        }

        return connectionValueMap;
    }

    public Map<AlgoConnection, Double> getStability(){
        return stability;
    }

    public Map<AlgoConnection, Double> getInevitability(){
        return inevitability;
    }

    public Map<AlgoMassProblem, Map<AlgoConnection, Double>> getCreateProbability(){
        return createProbability;
    }

    public Map<AlgoMassProblem, Map<AlgoConnection, Double>> getDestroyProbability(){
        return destroyProbability;
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
            Map<AlgoConnection, Set<AlgoConnectionInstance>> temporaryMap = (Map<AlgoConnection, Set<AlgoConnectionInstance>>)entry.getValue();

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
}
