package diploma.logic.algos.entities;

/**
 * Created by Артём on 09.04.2017.
 */
public class ObjInstance implements Comparable<ObjInstance> {
    private String name;

    public ObjInstance(String name) {
        this.name = name;
    }

    public int compareTo(ObjInstance o){
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof ObjInstance)) {
            return false;
        }

        ObjInstance otherObjInstance = (ObjInstance) other;

        return this.getName().equals(otherObjInstance.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
