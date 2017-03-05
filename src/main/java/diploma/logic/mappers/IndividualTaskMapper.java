package diploma.logic.mappers;

import diploma.logic.entities.IndividualTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class IndividualTaskMapper implements RowMapper<IndividualTask> {

    public IndividualTask mapRow(ResultSet rs, int rowNum) throws SQLException {
        IndividualTask individualTask = new IndividualTask();
        individualTask.setId(rs.getInt("individual_task_id"));
        individualTask.setMassProblemId(rs.getInt("mass_problem_id"));
        return individualTask;
    }
}
