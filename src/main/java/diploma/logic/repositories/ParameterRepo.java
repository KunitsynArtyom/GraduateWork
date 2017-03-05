package diploma.logic.repositories;

import diploma.logic.entities.Parameter;

import java.util.List;

/**
 * Created by Артём on 23.02.2017.
 */
public interface ParameterRepo extends Repo<Parameter> {

    List<Parameter> getAllParameterList();

    List<Parameter> findByMassProblemId(Integer id);
}
