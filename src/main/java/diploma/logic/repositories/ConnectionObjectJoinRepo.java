package diploma.logic.repositories;

import diploma.logic.entities.ConnectionObjectJoin;

import java.util.List;

/**
 * Created by Артём on 18.05.2017.
 */
public interface ConnectionObjectJoinRepo extends Repo<ConnectionObjectJoin>  {

    List<ConnectionObjectJoin> findByConnId(Integer id);
}
