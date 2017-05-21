package diploma.logic.mappers;

import diploma.logic.entities.ConnectionStateInstance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Артём on 20.05.2017.
 */
public class ConnectionStateInstanceMapper implements RowMapper<ConnectionStateInstance> {

    public ConnectionStateInstance mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConnectionStateInstance connectionStateInstance = new ConnectionStateInstance();
        connectionStateInstance.setConnectionStateId(rs.getInt("sd_state_id"));
        connectionStateInstance.setConnectionInstanceId(rs.getInt("сonnection_instance_id"));
        return connectionStateInstance;
    }
}
