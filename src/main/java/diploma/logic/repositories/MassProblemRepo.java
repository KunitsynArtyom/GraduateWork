package diploma.logic.repositories;

import diploma.logic.entities.MassProblem;

import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */
public interface MassProblemRepo extends Repo<MassProblem> {

    List<MassProblem> getAllMassProblemList();

    List<MassProblem> findBySDId(Integer id);
}
