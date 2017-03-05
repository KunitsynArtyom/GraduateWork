package diploma.logic.entities;

/**
 * Created by Артём on 13.02.2017.
 */
public class SubjectDomainState {

    private Integer id, subjectDomainId, timeStamp;

    public SubjectDomainState(){

    }

    public SubjectDomainState(Integer id, Integer subjectDomainId, Integer timeStamp){
        this.id = id;
        this.subjectDomainId = subjectDomainId;
        this.timeStamp = timeStamp;
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

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }




}
