package diploma.logic.repositories.impl;

import diploma.logic.entities.ObjectInstanceList;
import diploma.logic.mappers.ObjectInstanceListMapper;
import diploma.logic.repositories.ObjectInstanceListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Repository
public class ObjectInstanceListRepoImpl implements ObjectInstanceListRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_OBJ_INST_LISTS_LIST = "SELECT * FROM \"public\".\"object_instance_list\"";
    private static final String FIND_OBJ_INST_LIST_BY_CONN_INST = "SELECT * FROM object_instance_list WHERE connection_instance_id = ?;";

    @Autowired
    public ObjectInstanceListRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ObjectInstanceList> getAllObjectInstanceListsList(){
        return this.template.query(GET_ALL_OBJ_INST_LISTS_LIST, new Object[] {}, new ObjectInstanceListMapper());
    }

    public List<ObjectInstanceList> findObjectInstanceListByConnectionInstance(Integer id){
        return this.template.query(FIND_OBJ_INST_LIST_BY_CONN_INST, new Object[] {id}, new ObjectInstanceListMapper());
    }

    public ObjectInstanceList findById(Integer id){
        return null;
    }
}
