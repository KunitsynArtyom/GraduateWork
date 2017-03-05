package diploma.logic.entities;

/**
 * Created by Артём on 13.02.2017.
 */
public class SubjectDomain {

    private Integer id;
    private String name;

    public SubjectDomain(){

    }

    public SubjectDomain(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
