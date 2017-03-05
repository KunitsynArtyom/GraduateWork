package diploma.logic.repositories.impl;

import diploma.logic.entities.ParameterValue;
import diploma.logic.mappers.ParameterValueMapper;
import diploma.logic.repositories.ParameterValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 04.03.2017.
 */
@Repository
public class ParameterValueRepoImpl implements ParameterValueRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_PARAM_VAL_LIST = "SELECT * FROM \"public\".\"parameter_value\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"parameter_value\" WHERE parameter_value_id = ?";
    private static final String FIND_ID_BY_IND_TASK_ID_QUERY = "SELECT * FROM \"public\".\"parameter_value\" WHERE individual_task_id = ?";
    private static final String FIND_ID_BY_PARAM_ID_QUERY = "SELECT * FROM \"public\".\"parameter_value\" WHERE parameter_id = ?";

    @Autowired
    public ParameterValueRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<ParameterValue> getAllParameterValueList(){
        return this.template.query(GET_ALL_PARAM_VAL_LIST, new Object[] {}, new ParameterValueMapper());
    }

    public ParameterValue findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ParameterValueMapper());
    }

    public List<ParameterValue> findByIndividualTaskId(Integer id){
        return this.template.query(FIND_ID_BY_IND_TASK_ID_QUERY, new Object[] {id}, new ParameterValueMapper());
    }

    public List<ParameterValue> findByParameterId(Integer id){
        return this.template.query(FIND_ID_BY_PARAM_ID_QUERY, new Object[] {id}, new ParameterValueMapper());
    }
}
