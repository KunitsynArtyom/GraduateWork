package diploma.logic.entities;

/**
 * Created by Артём on 18.05.2017.
 */
public class ConnectionObjectJoin {

    private Integer connectionId, objectId;
    private String connectionName, objectName;

    public ConnectionObjectJoin() {

    }

    public ConnectionObjectJoin(Integer connectionId, Integer objectId, String connectionName, String objectName) {
        this.connectionId = connectionId;
        this.objectId = objectId;
        this.connectionName = connectionName;
        this.objectName = objectName;
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

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
