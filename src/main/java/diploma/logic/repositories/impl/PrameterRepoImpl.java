package diploma.logic.repositories.impl;

import diploma.logic.entities.Parameter;
import diploma.logic.mappers.ParameterMapper;
import diploma.logic.repositories.ParameterRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 23.02.2017.
 */
@Repository
public class PrameterRepoImpl implements ParameterRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_PARAM_LIST = "SELECT * FROM \"public\".\"parameter\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"parameter\" WHERE parameter_id = ?";
    private static final String FIND_ID_BY_MASS_PROB_ID_QUERY = "SELECT * FROM \"public\".\"parameter\" WHERE mass_problem_id = ?";

    @Autowired
    public PrameterRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Parameter> getAllParameterList(){
        return this.template.query(GET_ALL_PARAM_LIST, new Object[] {}, new ParameterMapper());
    }

    public Parameter findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new ParameterMapper());
    }

    public List<Parameter> findByMassProblemId(Integer id){
        return this.template.query(FIND_ID_BY_MASS_PROB_ID_QUERY, new Object[] {id}, new ParameterMapper());
    }
}
