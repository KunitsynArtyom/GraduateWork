package diploma.logic.repositories.impl;

import diploma.logic.entities.ConnectionState;
import diploma.logic.mappers.ConnectionStateMapper;
import diploma.logic.repositories.ConnectionStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class ConnectionStateRepoImpl implements ConnectionStateRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_CONN_STATE_LIST = "SELECT * FROM \"public\".\"connection_state\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"connection_state\" WHERE connection_state_id = ?";
    private static final String FIND_BY_SD_STATE_ID_QUERY = "SELECT * FROM \"public\".\"connection_state\" WHERE sd_state_id = ?";
    private static final String GET_ALL_DISTINCT_SD_STATE_ID_BY_SD_ID = "SELECT DISTINCT cs.sd_state_id " +
            "FROM connection_state cs, sd_state st " +
            "WHERE st.sd_state_id = cs.sd_state_id " +
            "AND st.sd_id = ?" +
            "ORDER BY cs.sd_state_id;";

    @Autowired
    public ConnectionStateRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ConnectionState> getAllConnectionStateList(){
        return this.template.query(GET_ALL_CONN_STATE_LIST, new Object[] {}, new ConnectionStateMapper());
    }

    public ConnectionState findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ConnectionStateMapper());
    }

    public List<ConnectionState> findBySDStateId(Integer id){
        return this.template.query(FIND_BY_SD_STATE_ID_QUERY, new Object[] {id}, new ConnectionStateMapper());
    }

    public List<Integer> getAllDistinctSDStateBySDId(Integer id){
        return this.template.queryForList(GET_ALL_DISTINCT_SD_STATE_ID_BY_SD_ID, new Object[] {id}, Integer.class);
    }

    public List<ConnectionState> findBySDId(Integer id){
        return null;
    }
}
