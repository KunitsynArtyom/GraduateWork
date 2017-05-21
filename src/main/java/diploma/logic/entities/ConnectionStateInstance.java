package diploma.logic.entities;

/**
 * Created by Артём on 20.05.2017.
 */
public class ConnectionStateInstance {

    private Integer connectionStateId, connectionInstanceId;

    public ConnectionStateInstance() {

    }

    public ConnectionStateInstance(Integer connectionStateId, Integer connectionInstanceId) {
        this.connectionStateId = connectionStateId;
        this.connectionInstanceId = connectionInstanceId;
    }

    public Integer getConnectionStateId() {
        return connectionStateId;
    }

    public void setConnectionStateId(Integer connectionStateId) {
        this.connectionStateId = connectionStateId;
    }

    public Integer getConnectionInstanceId() {
        return connectionInstanceId;
    }

    public void setConnectionInstanceId(Integer connectionInstanceId) {
        this.connectionInstanceId = connectionInstanceId;
    }
}
