/*
 */
package com.airhacks.odata;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.logging.LoggingFeature;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class MedatadataIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient().register(logging());
        this.tut = this.client.target("http://localhost:8080/odata/hello.svc/");
    }

    LoggingFeature logging() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        return new LoggingFeature(logger, Level.INFO, null, null);
    }

    @Test
    public void schema() {
        Response response = this.tut.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonObject metadata = response.readEntity(JsonObject.class);
        System.out.println(metadata);
    }

}
