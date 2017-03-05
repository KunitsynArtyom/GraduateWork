package diploma.logic.repositories.impl;

import diploma.logic.entities.SubjectDomainState;
import diploma.logic.mappers.SubjectDomainStateMapper;
import diploma.logic.repositories.SubjectDomainStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
@Repository
public class SubjectDomainStateRepoImpl implements SubjectDomainStateRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_SD_STATE_LIST = "SELECT * FROM \"public\".\"sd_state\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"sd_state\" WHERE sd_state_id = ?";
    private static final String FIND_ID_BY_SD_ID_QUERY = "SELECT * FROM \"public\".\"sd_state\" WHERE sd_id = ?";

    @Autowired
    public SubjectDomainStateRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<SubjectDomainState> getAllSDStateList(){
        return this.template.query(GET_ALL_SD_STATE_LIST, new Object[] {}, new SubjectDomainStateMapper());
    }

    public SubjectDomainState findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new SubjectDomainStateMapper());
    }

    public List<SubjectDomainState> findBySDId(Integer id){
        return this.template.query(FIND_ID_BY_SD_ID_QUERY, new Object[] {id}, new SubjectDomainStateMapper());
    }
}

