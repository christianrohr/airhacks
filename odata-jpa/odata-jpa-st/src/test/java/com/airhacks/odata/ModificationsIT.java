
package com.airhacks.odata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ModificationsIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient().register(Logging.log(this));
        this.tut = this.client.target("http://localhost:8080/odata-jpa/Vehicle.svc/Vehicles");
    }
    
    @Test
    public void newVehicle() {
        JsonObject newVehicle = Json.createObjectBuilder().
                add("Vin", "created " + System.currentTimeMillis()).
                add("Name", "porsche").build();
        JsonObject allVehicles = this.tut.
                request(MediaType.APPLICATION_JSON).
                post(Entity.json(newVehicle), JsonObject.class);
        System.out.println("allVehicles = " + allVehicles);
    }


    static String encode(String uri) {
        try {
            return URLEncoder.encode(uri, "utf-8")
                    .replace("+", "%20").replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException(ex);

        }
    }
}
