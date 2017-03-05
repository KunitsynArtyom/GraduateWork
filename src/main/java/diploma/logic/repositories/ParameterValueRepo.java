package diploma.logic.repositories;

import diploma.logic.entities.ParameterValue;

import java.util.List;

/**
 * Created by Артём on 04.03.2017.
 */
public interface ParameterValueRepo extends Repo<ParameterValue>  {

    List<ParameterValue> getAllParameterValueList();

    List<ParameterValue> findByIndividualTaskId(Integer id);

    List<ParameterValue> findByParameterId(Integer id);
}
