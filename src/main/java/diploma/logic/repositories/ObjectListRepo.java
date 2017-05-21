package diploma.logic.repositories;

import diploma.logic.entities.ObjectList;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface ObjectListRepo extends Repo<ObjectList> {

    List<ObjectList> getAllObjectListsList();

    List<ObjectList> findByConnId(Integer id);

    List<ObjectList> findByObjId(Integer id);
}
