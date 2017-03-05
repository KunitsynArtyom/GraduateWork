package diploma.logic.mappers;

import diploma.logic.entities.ObjectState;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 17.02.2017.
 */
public class ObjectStateMapper implements RowMapper<ObjectState> {

    public ObjectState mapRow(ResultSet rs, int rowNum) throws SQLException {
        ObjectState objectState = new ObjectState();
        objectState.setObjectInstanceId(rs.getInt("object_instance_id"));
        objectState.setAttributeValueId(rs.getInt("attribute_value_id"));
        objectState.setSubjectDonainStateId(rs.getInt("sd_state_id"));
        return objectState;
    }
}
