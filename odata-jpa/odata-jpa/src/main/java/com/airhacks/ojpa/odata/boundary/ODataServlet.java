
package com.airhacks.ojpa.odata.boundary;

import com.sap.olingo.jpa.processor.core.api.JPAODataCRUDContextAccess;
import com.sap.olingo.jpa.processor.core.api.JPAODataCRUDHandler;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.olingo.commons.api.ex.ODataException;

@WebServlet(urlPatterns = "/Vehicle.svc/*")
public class ODataServlet extends HttpServlet {

    @PersistenceUnit(unitName = "odata")
    EntityManagerFactory emf;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--- ODataServlet#service");

        try {
                final JPAODataCRUDContextAccess serviceContext
                    = (JPAODataCRUDContextAccess) getServletContext().getAttribute("ServiceContext");
            JPAODataCRUDHandler crudHandler = new JPAODataCRUDHandler(serviceContext);
            CreateUpdateDeleteRequestHandler handler = new CreateUpdateDeleteRequestHandler();
            crudHandler.getJPAODataRequestContext().setCUDRequestHandler(handler);
            crudHandler.process(req, resp);
        } catch (RuntimeException | ODataException e) {
                throw new ServletException(e);
        }
    }

}
