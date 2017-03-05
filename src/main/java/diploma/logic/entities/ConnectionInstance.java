package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionInstance {

    private Integer id, objectInstanceId;
    private String name;

    public ConnectionInstance(){

    }

    public ConnectionInstance(Integer id, Integer objectInstanceId, String name) {
        this.id = id;
        this.objectInstanceId = objectInstanceId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectInstanceId() {
        return objectInstanceId;
    }

    public void setObjectInstanceId(Integer objectInstanceId) {
        this.objectInstanceId = objectInstanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
