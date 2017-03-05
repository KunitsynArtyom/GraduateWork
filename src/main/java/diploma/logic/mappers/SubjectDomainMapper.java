package diploma.logic.mappers;

import diploma.logic.entities.SubjectDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 13.02.2017.
 */
public class SubjectDomainMapper implements RowMapper<SubjectDomain> {

    public SubjectDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
        SubjectDomain subjectDomain = new SubjectDomain();
        subjectDomain.setId(rs.getInt("sd_id"));
        subjectDomain.setName(rs.getString("sd_name"));
        return subjectDomain;
    }
}
