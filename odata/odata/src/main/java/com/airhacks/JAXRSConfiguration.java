package com.airhacks;

import javax.ws.rs.ApplicationPath;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.rest.app.AbstractODataApplication;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("hello.svc")
public class JAXRSConfiguration extends AbstractODataApplication {

    @Override
    public Class<? extends ODataServiceFactory> getServiceFactoryClass() {
        return AirhacksServiceFactory.class;
    }

}
