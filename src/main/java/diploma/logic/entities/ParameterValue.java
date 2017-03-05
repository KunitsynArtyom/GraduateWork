package diploma.logic.entities;

/**
 * Created by Артём on 17.02.2017.
 */
public class ParameterValue {

    private Integer id, individualTaskId, parameterId, parameterValue;

    public ParameterValue(){

    }

    public ParameterValue(Integer id, Integer individualTaskId, Integer parameterId, Integer parameterValue) {
        this.id = id;
        this.individualTaskId = individualTaskId;
        this.parameterId = parameterId;
        this.parameterValue = parameterValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndividualTaskId() {
        return individualTaskId;
    }

    public void setIndividualTaskId(Integer individualTaskId) {
        this.individualTaskId = individualTaskId;
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Integer parameterValue) {
        this.parameterValue = parameterValue;
    }
}
