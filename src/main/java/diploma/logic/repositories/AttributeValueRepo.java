package diploma.logic.repositories;

import diploma.logic.entities.AttributeValue;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
public interface AttributeValueRepo extends Repo<AttributeValue> {

    List<AttributeValue> getAllAttributeValueList();

    List<AttributeValue> findByAttributeId(Integer id);
}
