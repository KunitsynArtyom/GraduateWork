package diploma.logic.parsers.entities;

/**
 * Created by Артём on 01.04.2017.
 */
public class QueryAttribute {

    private String name, queryType;

    public QueryAttribute() {

    }

    public QueryAttribute(String name, String queryType) {
        this.name = name;
        this.queryType = queryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
