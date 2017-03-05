package diploma.logic.repositories.impl;

import diploma.logic.entities.IndividualTask;
import diploma.logic.mappers.IndividualTaskMapper;
import diploma.logic.repositories.IndividualTaskRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 23.02.2017.
 */
@Repository
public class IndividualTaskRepoImpl implements IndividualTaskRepo {


    private JdbcTemplate template;

    private static final String GET_ALL_IND_TASK_LIST = "SELECT * FROM \"public\".\"individual_task\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"individual_task\" WHERE individual_task_id = ?";
    private static final String FIND_ID_BY_MASS_PROB_ID_QUERY = "SELECT * FROM \"public\".\"individual_task\" WHERE mass_problem_id = ?";

    @Autowired
    public IndividualTaskRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<IndividualTask> getAllIndividualTaskList(){
        return this.template.query(GET_ALL_IND_TASK_LIST, new Object[] {}, new IndividualTaskMapper());
    }

    public IndividualTask findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new IndividualTaskMapper());
    }

    public List<IndividualTask> findByMassProblemId(Integer id){
        return this.template.query(FIND_ID_BY_MASS_PROB_ID_QUERY, new Object[] {id}, new IndividualTaskMapper());
    }
}
