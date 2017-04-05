package diploma.logic.parsers.entities;

/**
 * Created by Артём on 01.04.2017.
 */
public class QueryAttribute implements Comparable<QueryAttribute> {
    private String name;

    public QueryAttribute(String name) {
        this.name = name;
    }

    public int compareTo(QueryAttribute o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof QueryAttribute)) {
            return false;
        }

        QueryAttribute otherAttribute = (QueryAttribute) other;

        return this.getName().equals(otherAttribute.getName());
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
