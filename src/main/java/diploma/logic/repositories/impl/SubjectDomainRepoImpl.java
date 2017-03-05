package diploma.logic.repositories.impl;

import diploma.logic.entities.SubjectDomain;
import diploma.logic.mappers.SubjectDomainMapper;
import diploma.logic.repositories.SubjectDomainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
@Repository
public class SubjectDomainRepoImpl implements SubjectDomainRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_SD_LIST = "SELECT * FROM \"public\".\"subject_domain\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"subject_domain\" WHERE sd_id = ?";


    @Autowired
    public SubjectDomainRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<SubjectDomain> getAllSDList(){
        return this.template.query(GET_ALL_SD_LIST, new Object[] {}, new SubjectDomainMapper());
    }

    public SubjectDomain findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new SubjectDomainMapper());
    }
}
