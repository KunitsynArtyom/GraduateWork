package diploma.logic.entities;

/**
 * Created by Артём on 14.02.2017.
 */
public class ObjectInstance {

    private Integer id, object_id;
    private String name;

    public ObjectInstance(){

    }

    public ObjectInstance(Integer id, Integer object_id,String name) {
        this.id = id;
        this.object_id = object_id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObject_id() {
        return object_id;
    }

    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
