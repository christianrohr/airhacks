package com.airhacks.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

/**
 *
 * @author airhacks.com
 */
public class Pojo {

    private String name;
    private Key key;
    private List<Property> properties;

    private Pojo(String name) {
        this.name = name;
        this.properties = new LinkedList<>();
    }

    public static class Builder {

        private Pojo pojo;

        public Builder(String name) {
            this.pojo = new Pojo(name);
        }

        public Builder withStringProperty(String name) {
            this.pojo.properties.add(new SimpleProperty().setName(name).setType(EdmSimpleTypeKind.String));
            return this;
        }

        public Builder withStringPropertyAsKey(String name) {
            withStringProperty(name);
            this.pojo.key = createKey(name);
            return this;
        }

        public Builder withIntegerProperty(String name) {
            this.pojo.properties.add(new SimpleProperty().setName(name).setType(EdmSimpleTypeKind.Int32));
            return this;
        }

        public Builder withIntegerPropertyAsKey(String name) {
            withIntegerProperty(name);
            this.pojo.key = createKey(name);
            return this;
        }

        Key createKey(String name) {
            List<PropertyRef> propertyRefs = new ArrayList<>();
            propertyRefs.add(new PropertyRef().setName(name));
            return new Key().setKeys(propertyRefs);
        }

        public EntityType toEntityType() {
            EntityType entityType = new EntityType();
            entityType.setName(this.pojo.name);
            entityType.setProperties(this.pojo.properties);
            entityType.setKey(this.pojo.key);
            return entityType;
        }

    }

}
