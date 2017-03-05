package diploma.logic.repositories;

import diploma.logic.entities.ObjectInstanceList;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface ObjectInstanceListRepo extends Repo<ObjectInstanceList> {

    List<ObjectInstanceList> getAllObjectInstanceListsList();
}
