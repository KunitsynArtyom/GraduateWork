package diploma.logic.entities;

/**
 * Created by Артём on 14.02.2017.
 */
public class Attribute {

    private Integer id, objectId;
    private String name;

    public Attribute(){

    }

    public Attribute(Integer id, Integer objectId, String name) {
        this.id = id;
        this.objectId = objectId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
