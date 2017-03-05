package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class Connection {

    private Integer id, subjectDomainId;
    String name;

    public Connection(){

    }

    public Connection(Integer id, Integer subjectDomainId, String name) {
        this.id = id;
        this.subjectDomainId = subjectDomainId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectDomainId() {
        return subjectDomainId;
    }

    public void setSubjectDomainId(Integer subjectDomainId) {
        this.subjectDomainId = subjectDomainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
