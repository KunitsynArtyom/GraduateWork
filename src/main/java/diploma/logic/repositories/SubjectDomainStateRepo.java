package diploma.logic.repositories;

import diploma.logic.entities.SubjectDomainState;

import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
public interface SubjectDomainStateRepo extends Repo<SubjectDomainState> {

    List<SubjectDomainState> getAllSDStateList();

    List<SubjectDomainState> findBySDId(Integer id);
}
