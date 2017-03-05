package diploma.logic.mappers;

import diploma.logic.entities.ParameterValue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ParameterValueMapper implements RowMapper<ParameterValue> {

    public ParameterValue mapRow(ResultSet rs, int rowNum) throws SQLException {
        ParameterValue parameterValue = new ParameterValue();
        parameterValue.setId(rs.getInt("parameter_value_id"));
        parameterValue.setIndividualTaskId(rs.getInt("individual_task_id"));
        parameterValue.setParameterId(rs.getInt("parameter_id"));
        parameterValue.setParameterValue(rs.getInt("parameter_value"));
        return parameterValue;
    }
}
