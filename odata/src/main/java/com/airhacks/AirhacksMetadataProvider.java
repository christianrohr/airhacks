
package com.airhacks;

import com.airhacks.entity.Pojo;
import java.util.ArrayList;
import java.util.List;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityContainer;
import org.apache.olingo.odata2.api.edm.provider.EntityContainerInfo;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.exception.ODataException;

/**
 *
 * @author airhacks.com
 */
public class AirhacksMetadataProvider extends EdmProvider {

    final static String NAMESPACE = "airspace";

    @Override
    public List<Schema> getSchemas() throws ODataException {
        List<Schema> schemas = new ArrayList<>();
        Schema schema = new Schema();
        schema.setEntityTypes(this.getEntityTypes());
        schema.setEntityContainers(this.getEntityContainers());
        schema.setNamespace(NAMESPACE);
        schemas.add(schema);
        return schemas;
    }

    @Override
    public EntityContainerInfo getEntityContainerInfo(String name) throws ODataException {
        return new EntityContainerInfo().setName(name).setDefaultEntityContainer(true);
    }

    @Override
    public EntitySet getEntitySet(final String entityContainer, final String name) throws ODataException {
        FullQualifiedName fqn = new FullQualifiedName(NAMESPACE, name);
        return new EntitySet().setName(name).setEntityType(fqn);
    }

    @Override
    public EntityType getEntityType(final FullQualifiedName edmFQName) throws ODataException {
        EntityType type = new Pojo.Builder(edmFQName.getName()).
                withIntegerProperty("name").
                withIntegerProperty("age").
                withStringProperty("skills").
                toEntityType();
        return type;
    }

    List<EntityType> getEntityTypes() throws ODataException {
        List<EntityType> entities = new ArrayList<>();
        entities.add(getEntityType(new FullQualifiedName(NAMESPACE, "Duke")));
        entities.add(getEntityType(new FullQualifiedName(NAMESPACE, "Java")));
        return entities;
    }

    List<EntitySet> getEntitySets() throws ODataException {
        List<EntitySet> sets = new ArrayList<>();
        sets.add(getEntitySet(null, "Dukes"));
        sets.add(getEntitySet(null, "Javas"));
        return sets;
    }

    List<EntityContainer> getEntityContainers() throws ODataException {
        List<EntityContainer> entityContainers = new ArrayList<>();
         EntityContainer entityContainer = new EntityContainer();
         entityContainer.setEntitySets(getEntitySets());
        entityContainer.setName("AirhacksContainer").setDefaultEntityContainer(true);
        entityContainers.add(entityContainer);
        return entityContainers;
    }
}
