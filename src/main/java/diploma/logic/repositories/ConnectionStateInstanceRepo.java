package diploma.logic.repositories;

import diploma.logic.entities.ConnectionStateInstance;

import java.util.List;

/**
 * Created by Артём on 20.05.2017.
 */
public interface ConnectionStateInstanceRepo extends Repo<ConnectionStateInstance> {

    List<ConnectionStateInstance> getOrderedByConnectionInstanceList(Integer id);
}
