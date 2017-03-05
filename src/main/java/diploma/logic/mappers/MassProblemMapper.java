package diploma.logic.mappers;

import diploma.logic.entities.MassProblem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class MassProblemMapper implements RowMapper<MassProblem> {

    public MassProblem mapRow(ResultSet rs, int rowNum) throws SQLException {
        MassProblem massProblem = new MassProblem();
        massProblem.setId(rs.getInt("mass_problem_id"));
        massProblem.setSubjectDomainId(rs.getInt("sd_id"));
        massProblem.setName(rs.getString("mass_problem_name"));
        return massProblem;
    }
}
