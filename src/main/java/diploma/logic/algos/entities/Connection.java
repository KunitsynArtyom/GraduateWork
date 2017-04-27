package diploma.logic.algos.entities;

/**
 * Created by Артём on 09.04.2017.
 */
public class Connection implements Comparable<Connection> {
    private Obj obj1, obj2;
    private String name;

    public Connection(Obj obj1, Obj obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.name = toString();
    }

    public int compareTo(Connection o){
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Connection)) {
            return false;
        }

        Connection otherConnection = (Connection) other;

        return this.getName().equals(otherConnection.getName()) && this.obj1.equals(otherConnection.getObj1()) && this.obj2.equals(otherConnection.getObj2());
    }

    public Obj getObj1() {
        return obj1;
    }

    public Obj getObj2() {
        return obj2;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getObj1() + " - " + this.getObj2();
    }
}
