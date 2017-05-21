package diploma.logic.repositories;

import diploma.logic.entities.ObjectInstance;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface ObjectInstanceRepo extends Repo<ObjectInstance> {

    List<ObjectInstance> getAllObjectInstanceList();

    List<ObjectInstance> findByObjId(Integer id);
}
