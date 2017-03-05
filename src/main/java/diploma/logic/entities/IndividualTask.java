package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class IndividualTask {

    private Integer id, massProblemId;

    public IndividualTask(){

    }

    public IndividualTask(Integer id, Integer massProblemId) {
        this.id = id;
        this.massProblemId = massProblemId;
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
}
