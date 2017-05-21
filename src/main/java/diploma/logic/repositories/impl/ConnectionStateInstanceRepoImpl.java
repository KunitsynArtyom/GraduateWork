package diploma.logic.repositories.impl;

import diploma.logic.entities.ConnectionStateInstance;
import diploma.logic.mappers.ConnectionStateInstanceMapper;
import diploma.logic.repositories.ConnectionStateInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 20.05.2017.
 */
@Repository
public class ConnectionStateInstanceRepoImpl implements ConnectionStateInstanceRepo {

    private JdbcTemplate template;

    private static final String GET_ORDERED_BY_CONNECTION_INSTANCE_LIST = "SELECT cs.sd_state_id, cs.сonnection_instance_id " +
            "FROM \"public\".\"sd_state\" st, \"public\".\"connection_state\" cs " +
            "WHERE st.sd_id = ? " +
            "AND cs.sd_state_id = st.sd_state_id " +
            "ORDER BY st.timestamp;";

    @Autowired
    public ConnectionStateInstanceRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ConnectionStateInstance> getOrderedByConnectionInstanceList(Integer id){
        return this.template.query(GET_ORDERED_BY_CONNECTION_INSTANCE_LIST, new Object[] {id}, new ConnectionStateInstanceMapper());
    }

    public ConnectionStateInstance findById(Integer id){
        return null;
    }
}
