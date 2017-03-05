package diploma.logic.repositories;

import diploma.logic.entities.SubjectDomain;

import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
public interface SubjectDomainRepo extends Repo<SubjectDomain> {

/*    SubjectDomain findNameById(Integer id);*/

    List<SubjectDomain> getAllSDList();

/*    void insert(SubjectDomain entity);*/
}
