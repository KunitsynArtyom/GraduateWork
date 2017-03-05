package diploma.logic.mappers;

import diploma.logic.entities.ConnectionState;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Артём on 17.02.2017.
 */
public class ConnectionStateMapper implements RowMapper<ConnectionState> {

    public ConnectionState mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConnectionState connectionState = new ConnectionState();
        connectionState.setId(rs.getInt("connection_state_id"));
        connectionState.setSubjectDomainStateId(rs.getInt("sd_state_id"));
        connectionState.setConnectionInstanceId(rs.getInt("сonnection_instance_id"));
        connectionState.setName(rs.getString("connection_state_name"));
        return connectionState;
    }
}
