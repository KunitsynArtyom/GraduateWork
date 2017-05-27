package diploma.logic.repositories;

import diploma.logic.entities.IndividualTask;

import java.util.List;

/**
 * Created by Артём on 23.02.2017.
 */
public interface IndividualTaskRepo extends Repo<IndividualTask> {

    List<IndividualTask> getAllIndividualTaskList();

    List<IndividualTask> findByMassProblemId(Integer id);

    List<IndividualTask> getOrderedIndividualTaskListForSD(Integer id);
}
