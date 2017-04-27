package diploma.logic.algos.entities;

import java.util.List;

/**
 * Created by Артём on 09.04.2017.
 */
public class Obj {
    private String name;
    private List<ObjInstance> objectInstanceList;

    public Obj(String name) {
        this.name = name;
    }

    public Obj(String name, List<ObjInstance> objectInstanceList) {
        this.name = name;
        this.objectInstanceList = objectInstanceList;
    }

    public String getName() {
        return name;
    }

    public List<ObjInstance> getObjectInstanceList() {
        return objectInstanceList;
    }

    public void setObjectInstanceList(List<ObjInstance> objectInstanceList) {
        this.objectInstanceList = objectInstanceList;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
