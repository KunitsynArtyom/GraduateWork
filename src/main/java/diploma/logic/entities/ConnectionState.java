package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionState {

    private Integer id, subjectDomainStateId, connectionInstanceId;
    private String name;

    public ConnectionState(){

    }

    public ConnectionState(Integer id, Integer subjectDomainStateId, Integer connectionInstanceId, String name) {
        this.id = id;
        this.subjectDomainStateId = subjectDomainStateId;
        this.connectionInstanceId = connectionInstanceId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectDomainStateId() {
        return subjectDomainStateId;
    }

    public void setSubjectDomainStateId(Integer subjectDomainStateId) {
        this.subjectDomainStateId = subjectDomainStateId;
    }

    public Integer getConnectionInstanceId() {
        return connectionInstanceId;
    }

    public void setConnectionInstanceId(Integer connectionInstanceId) {
        this.connectionInstanceId = connectionInstanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
