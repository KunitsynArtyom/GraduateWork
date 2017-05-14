package diploma.logic.repositories.impl;

import diploma.logic.entities.MassProblem;
import diploma.logic.mappers.MassProblemMapper;
import diploma.logic.repositories.MassProblemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
/**
 * Created by Артём on 19.02.2017.
 */
@Repository
public class MassProblemRepoImpl implements MassProblemRepo {

    private JdbcTemplate template;

    private static final String GET_ALL_MP_LIST = "SELECT * FROM \"public\".\"mass_problem\"";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM \"public\".\"mass_problem\" WHERE mass_problem_id = ?";
    private static final String FIND_BY_SD_ID_QUERY = "SELECT * FROM \"public\".\"mass_problem\" WHERE sd_id = ?";
    private static final String GET_ALL_DISTINCT_SD_LIST = "SELECT DISTINCT sd_id FROM \"public\".\"mass_problem\"";

    @Autowired
    public MassProblemRepoImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public List<MassProblem> getAllMassProblemList(){
        return this.template.query(GET_ALL_MP_LIST, new Object[] {}, new MassProblemMapper());
    }

    public MassProblem findById(Integer id){
        return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] {id}, new MassProblemMapper());
    }

    public List<MassProblem> findBySDId(Integer id){
        return this.template.query(FIND_BY_SD_ID_QUERY, new Object[] {id}, new MassProblemMapper());
    }

    public List<String> getAllDistinctSDList(){
        return this.template.queryForList(GET_ALL_DISTINCT_SD_LIST, String.class);
    }
}
