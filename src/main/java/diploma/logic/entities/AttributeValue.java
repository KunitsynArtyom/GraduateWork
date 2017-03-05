package diploma.logic.entities;

/**
 * Created by Артём on 14.02.2017.
 */
public class AttributeValue {

    private Integer id, attributeId, attributeValue;

    public AttributeValue(){

    }

    public AttributeValue(Integer id, Integer attributeId, Integer attributeValue) {
        this.id = id;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Integer attributeValue) {
        this.attributeValue = attributeValue;
    }
}
