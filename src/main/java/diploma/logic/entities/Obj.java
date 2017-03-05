package diploma.logic.entities;

/**
 * Created by Артём on 14.02.2017.
 */
public class Obj {

    private Integer id, subjectDomainId, objectInstanceId;
    private String name;

    public Obj() {

    }

    public Obj(Integer id, Integer subjectDomainId,
               Integer objectInstanceId, String name) {
        this.id = id;
        this.subjectDomainId = subjectDomainId;
        this.objectInstanceId = objectInstanceId;
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
