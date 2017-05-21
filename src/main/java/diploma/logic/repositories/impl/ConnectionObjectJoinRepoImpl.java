package diploma.logic.repositories.impl;

import diploma.logic.entities.ConnectionObjectJoin;
import diploma.logic.mappers.ConnectionObjectJoinMapper;
import diploma.logic.repositories.ConnectionObjectJoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 18.05.2017.
 */
@Repository
public class ConnectionObjectJoinRepoImpl implements ConnectionObjectJoinRepo {

    private JdbcTemplate template;

    private static final String FIND_BY_CONN_ID = "SELECT c.connection_id, o.object_id, c.connection_name, o.obj_name " +
            "FROM \"public\".\"connection\" c " +
            "INNER JOIN \"public\".\"object_list\" ol ON c.connection_id = ol.connection_id " +
            "LEFT JOIN \"public\".\"object\" o ON ol.object_id = o.object_id " +
            "WHERE c.connection_id = ?;";

    @Autowired
    public ConnectionObjectJoinRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ConnectionObjectJoin> findByConnId(Integer id){
        return this.template.query(FIND_BY_CONN_ID, new Object[] {id}, new ConnectionObjectJoinMapper());
    }

    public ConnectionObjectJoin findById(Integer id){
        return null;
    }
}
