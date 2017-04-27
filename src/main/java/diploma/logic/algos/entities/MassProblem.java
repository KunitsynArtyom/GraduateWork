package diploma.logic.algos.entities;

/**
 * Created by Артём on 16.04.2017.
 */
public class MassProblem implements Comparable<MassProblem> {

    private String name;

    public MassProblem(String name) {
        this.name = name;
    }

    public int compareTo(MassProblem o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof ConnectionInstance)) {
            return false;
        }

        MassProblem otherMassProblem = (MassProblem) other;

        return this.getName() == otherMassProblem.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
