package diploma.logic.repositories.impl;

import diploma.logic.entities.ObjectList;
import diploma.logic.mappers.ObjectListMapper;
import diploma.logic.repositories.ObjectListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class ObjectListRepoImpl implements ObjectListRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_OBJ_LISTS_LIST = "SELECT * FROM \"public\".\"object_list\"";
    private static final String FIND_OBJ_LISTS_BY_OBJ_ID = "SELECT * FROM \"public\".\"object_list\" WHERE object_id = ?";
    private static final String FIND_OBJ_LISTS_BY_CONN_ID = "SELECT * FROM \"public\".\"object_list\" WHERE connection_id = ?";

    @Autowired
    public ObjectListRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ObjectList> getAllObjectListsList(){
        return this.template.query(GET_ALL_OBJ_LISTS_LIST, new Object[] {}, new ObjectListMapper());
    }

    public List<ObjectList> findByObjId(Integer id){
        return this.template.query(FIND_OBJ_LISTS_BY_OBJ_ID, new Object[] {id}, new ObjectListMapper());
    }

    public List<ObjectList> findByConnId(Integer id){
        return this.template.query(FIND_OBJ_LISTS_BY_CONN_ID, new Object[] {id}, new ObjectListMapper());
    }

    public ObjectList findById(Integer id){
        return null;
    }
}
