package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectInstanceList {

    private Integer connectionInstanceId, objectInstanceId;

    public ObjectInstanceList(){

    }

    public ObjectInstanceList(Integer connectionInstanceId, Integer objectInstanceId) {
        this.connectionInstanceId = connectionInstanceId;
        this.objectInstanceId = objectInstanceId;
    }

    public Integer getConnectionInstanceId() {
        return connectionInstanceId;
    }

    public void setConnectionInstanceId(Integer connectionInstanceId) {
        this.connectionInstanceId = connectionInstanceId;
    }

    public Integer getObjectInstanceId() {
        return objectInstanceId;
    }

    public void setObjectInstanceId(Integer objectInstanceId) {
        this.objectInstanceId = objectInstanceId;
    }
}
