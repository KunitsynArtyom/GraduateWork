package diploma.logic.repositories;

import diploma.logic.entities.ConnectionInstance;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface ConnectionInstanceRepo  extends Repo<ConnectionInstance> {

    List<ConnectionInstance> getAllConnectionInstanceList();

    List<ConnectionInstance> findByObjectInstanceId(Integer id);
}
