package diploma.logic.mappers;

import diploma.logic.entities.Parameter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ParameterMapper implements RowMapper<Parameter> {

    public Parameter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parameter parameter = new Parameter();
        parameter.setId(rs.getInt("parameter_id"));
        parameter.setMassProblemId(rs.getInt("mass_problem_id"));
        parameter.setName(rs.getString("parameter_name"));
        return parameter;
    }
}
