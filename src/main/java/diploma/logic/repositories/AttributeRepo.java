package diploma.logic.repositories;

import diploma.logic.entities.Attribute;

import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */
public interface AttributeRepo extends Repo<Attribute> {

    List<Attribute> getAllAttributeList();

    List<Attribute> findByObjId(Integer id);
}
