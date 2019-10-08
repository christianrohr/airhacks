
package com.airhacks.ojpa.odata.boundary;

import com.sap.olingo.jpa.processor.core.api.JPAODataCRUDContextAccess;
import com.sap.olingo.jpa.processor.core.api.JPAODataServiceContext;
import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import org.apache.olingo.commons.api.ex.ODataException;

@WebListener
public class ODataCRUDInitialization implements ServletContextListener {

    @Resource(lookup = "java:comp/DefaultDataSource")
    DataSource dataSource;

    public static final String PERSISTENCE_UNIT = "odata";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--- contextInitialized");
        try {
            final JPAODataCRUDContextAccess serviceContext
                    = JPAODataServiceContext.with()
                            .setPUnit(PERSISTENCE_UNIT)
                            .setDataSource(this.dataSource)
                            .setTypePackage("com.airhacks.ojpa.vehicles.entity")
                            .build();

            sce.getServletContext().setAttribute("ServiceContext", serviceContext);
        } catch (ODataException e) {
            System.out.println("!!!!! " + e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("ServiceContext", null);
    }

}
