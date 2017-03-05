package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectState {

    private Integer objectInstanceId, attributeValueId, subjectDonainStateId;

    public ObjectState(){

    }

    public ObjectState(Integer objectInstanceId, Integer attributeValueId, Integer subjectDonainStateId) {
        this.objectInstanceId = objectInstanceId;
        this.attributeValueId = attributeValueId;
        this.subjectDonainStateId = subjectDonainStateId;
    }

    public Integer getObjectInstanceId() {
        return objectInstanceId;
    }

    public void setObjectInstanceId(Integer id) {
        this.objectInstanceId = id;
    }

    public Integer getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Integer attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public Integer getSubjectDonainStateId() {
        return subjectDonainStateId;
    }

    public void setSubjectDonainStateId(Integer subjectDonainStateId) {
        this.subjectDonainStateId = subjectDonainStateId;
    }
}
