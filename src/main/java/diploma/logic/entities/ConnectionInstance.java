package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionInstance {

    private Integer id, connectionId;
    private String name;

    public ConnectionInstance(){

    }

    public ConnectionInstance(Integer id, Integer connectionId, String name) {
        this.id = id;
        this.connectionId = connectionId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connection_id) {
        this.connectionId = connection_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
