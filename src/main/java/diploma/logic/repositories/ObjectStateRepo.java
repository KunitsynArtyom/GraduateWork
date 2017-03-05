package diploma.logic.repositories;

import diploma.logic.entities.ObjectState;

import java.util.List;

/**
 * Created by Артём on 05.03.2017.
 */
public interface ObjectStateRepo extends Repo<ObjectState> {

    List<ObjectState> getAllObjectStateList();

    List<ObjectState> findByAttributeValueId(Integer id);
}
