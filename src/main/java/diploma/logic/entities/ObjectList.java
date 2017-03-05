package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectList {

    private Integer connectionId, objectId;

    public ObjectList(){

    }

    public ObjectList(Integer connectionId, Integer objectId) {
        this.connectionId = connectionId;
        this.objectId = objectId;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
}
