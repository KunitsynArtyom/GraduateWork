package diploma.logic.algos.entities;

/**
 * Created by Артём on 16.04.2017.
 */
public class AlgoMassProblem implements Comparable<AlgoMassProblem> {

    private String name;

    public AlgoMassProblem(String name) {
        this.name = name;
    }

    public int compareTo(AlgoMassProblem o) {

        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof AlgoMassProblem)) {
            return false;
        }

        AlgoMassProblem otherMassProblem = (AlgoMassProblem) other;

        return this.getName().equals(otherMassProblem.getName());
    }

    @Override
    public int hashCode(){
        return this.getName().length();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
