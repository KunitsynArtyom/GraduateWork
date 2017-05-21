package diploma.logic.algos.entities;

/**
 * Created by Артём on 09.04.2017.
 */
public class AlgoConnectionInstance implements Comparable<AlgoConnectionInstance>  {
    private String field1, field2, name;

    public AlgoConnectionInstance(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
        this.name = toString();
    }

    public int compareTo(AlgoConnectionInstance o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof AlgoConnectionInstance)) {
            return false;
        }

        AlgoConnectionInstance otherConnectionInstance = (AlgoConnectionInstance) other;

        return this.getName().equals(otherConnectionInstance.getName()) && this.getField1().equals(otherConnectionInstance.getField1()) && this.getField2().equals(otherConnectionInstance.getField2());
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
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
        return this.getField1() + " - " + this.getField2();
    }
}
