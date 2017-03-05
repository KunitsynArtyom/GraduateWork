package diploma.logic.repositories.impl;

import diploma.logic.entities.ObjectState;
import diploma.logic.mappers.ObjectStateMapper;
import diploma.logic.repositories.ObjectStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 05.03.2017.
 */
@Repository
public class ObjectStateRepoImpl implements ObjectStateRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_OBJ_STATE_LIST = "SELECT * FROM \"public\".\"object_state\"";
    private static final String FIND_BY_ATT_VAL_ID_QUERY = "SELECT * FROM \"public\".\"object_state\" WHERE attribute_value_id = ?";

    @Autowired
    public ObjectStateRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ObjectState> getAllObjectStateList(){
        return this.template.query(GET_ALL_OBJ_STATE_LIST, new Object[] {}, new ObjectStateMapper());
    }

    public ObjectState findById(Integer id){
        return null;
    }

    public List<ObjectState> findByAttributeValueId(Integer id){
        return this.template.query(FIND_BY_ATT_VAL_ID_QUERY, new Object[] {id}, new ObjectStateMapper());
    }
}
