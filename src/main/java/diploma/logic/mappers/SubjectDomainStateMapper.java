package diploma.logic.mappers;

import diploma.logic.entities.SubjectDomainState;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 13.02.2017.
 */

public class SubjectDomainStateMapper implements RowMapper<SubjectDomainState> {

    public SubjectDomainState mapRow(ResultSet rs, int rowNum) throws SQLException {
        SubjectDomainState subjectDomainState = new SubjectDomainState();
        subjectDomainState.setId(rs.getInt("sd_state_id"));
        subjectDomainState.setSubjectDomainId(rs.getInt("sd_id"));
        subjectDomainState.setTimeStamp(rs.getInt("timestamp"));
        return subjectDomainState;
    }
}
