package diploma.logic.algos.entities;

/**
 * Created by Артём on 09.04.2017.
 */
public class AlgoObjInstance implements Comparable<AlgoObjInstance> {
    private String name;

    public AlgoObjInstance(String name) {
        this.name = name;
    }

    public int compareTo(AlgoObjInstance o){
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof AlgoObjInstance)) {
            return false;
        }

        AlgoObjInstance otherObjInstance = (AlgoObjInstance) other;

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
