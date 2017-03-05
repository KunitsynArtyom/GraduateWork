package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class Parameter {

    private Integer id, massProblemId;
    private String name;

    public Parameter(){

    }

    public Parameter(Integer id, Integer massProblemId, String name) {
        this.id = id;
        this.massProblemId = massProblemId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
