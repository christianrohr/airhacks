
package com.airhacks.ojpa.odata.boundary;

import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAEntityType;
import com.sap.olingo.jpa.processor.core.api.JPAAbstractCUDRequestHandler;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.processor.JPAModifyUtil;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;

/**
 * Creates entities
 */
public class CreateUpdateDeleteRequestHandler extends JPAAbstractCUDRequestHandler {

    @Override
    public Object createEntity(JPARequestEntity requestEntity, EntityManager em) throws ODataJPAProcessException {
        JPAEntityType entityType = requestEntity.getEntityType();
        Class<?> typeClass = entityType.getTypeClass();
        try {
            Object entity = typeClass.getDeclaredConstructor().newInstance();
            JPAModifyUtil modifyUtil = requestEntity.getModifyUtil();
            modifyUtil.setAttributesDeep(requestEntity.getData(), entity, requestEntity.getEntityType());
            return entity;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new IllegalStateException(ex);
        }
    }

}
