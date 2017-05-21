package diploma.logic.algos.entities;

import java.util.List;

/**
 * Created by Артём on 09.04.2017.
 */
public class AlgoObj {
    private String name;
    private List<AlgoObjInstance> objectInstanceList;

    public AlgoObj(String name) {
        this.name = name;
    }

    public AlgoObj(String name, List<AlgoObjInstance> objectInstanceList) {
        this.name = name;
        this.objectInstanceList = objectInstanceList;
    }

    public String getName() {
        return name;
    }

    public List<AlgoObjInstance> getObjectInstanceList() {
        return objectInstanceList;
    }

    public void setObjectInstanceList(List<AlgoObjInstance> objectInstanceList) {
        this.objectInstanceList = objectInstanceList;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
