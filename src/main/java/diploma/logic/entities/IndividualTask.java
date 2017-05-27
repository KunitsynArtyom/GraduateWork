package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class IndividualTask {

    private Integer id, massProblemId, priority;
    private String individualTask;

    public IndividualTask(){

    }

    public IndividualTask(Integer id, Integer massProblemId, Integer priority, String individualTask) {
        this.id = id;
        this.massProblemId = massProblemId;
        this.priority = priority;
        this.individualTask = individualTask;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMassProblemId() {
        return massProblemId;
    }

    public void setMassProblemId(Integer massProblemId) {
        this.massProblemId = massProblemId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getIndividualTask() {
        return individualTask;
    }

    public void setIndividualTask(String individualTask) {
        this.individualTask = individualTask;
    }
}
