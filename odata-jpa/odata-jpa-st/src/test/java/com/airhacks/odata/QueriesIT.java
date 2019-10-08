
package com.airhacks.odata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class QueriesIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient().register(Logging.log(this));
        this.tut = this.client.target("http://localhost:8080/odata-jpa/Vehicle.svc/");
    }
    
    @Test
    public void allVehicles() {
        JsonObject allVehicles = this.tut.
                path("Vehicles").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("allVehicles = " + allVehicles);
    }

    @Test
    public void filterVehiclesByName() {
        JsonObject allVehicles = this.tut.
                path("Vehicles").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("allVehicles = " + allVehicles);
    }

    @Test
    public void findVehicleById() {
        JsonObject allVehicles = this.tut.
                path("Vehicles").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("allVehicles = " + allVehicles);
        JsonArray array = allVehicles.getJsonArray("value");
        JsonObject firstVehicle = array.getJsonObject(0);
        assertNotNull(firstVehicle);
        String vin = firstVehicle.getString("Vin");
        assertNotNull(vin);

        JsonObject retrievedVehicle = this.tut.
                path("Vehicles('" + vin + "')").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle = " + retrievedVehicle);
    }

    @Test
    public void filterVehicleByName() {
        JsonObject allVehicles = this.tut.
                path("Vehicles").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("allVehicles = " + allVehicles);
        JsonArray array = allVehicles.getJsonArray("value");
        JsonObject firstVehicle = array.getJsonObject(0);
        assertNotNull(firstVehicle);
        String vin = firstVehicle.getString("Vin");
        assertNotNull(vin);

        JsonObject retrievedVehicle = this.tut.
                path("Vehicles('" + vin + "')").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle = " + retrievedVehicle);
    }

    @Test
    public void requestASingleProperty() {
        String vin = "42";
        JsonObject retrievedVehicle = this.tut.
                path("Vehicles('" + vin + "')/Name").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle = " + retrievedVehicle);
    }

    @Test
    public void findVehicleWithNameEqual() throws UnsupportedEncodingException {
        this.findVehicleWithOperator("eq");
    }

    @Test
    public void findVehicleWithNameNotEqual() throws UnsupportedEncodingException {
        this.findVehicleWithOperator("ne");
    }

    public void findVehicleWithOperator(String operator) throws UnsupportedEncodingException {
        JsonObject retrievedVehicle = this.tut.
                path("Vehicles").
                queryParam("$filter", encode("Name " + operator + " 'Hans Hirsch'")).
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle with " + operator + " = " + retrievedVehicle);
        JsonValue value = retrievedVehicle.get("value");
        System.out.println("value = " + value);
    }

    @Test
    public void allVehiclesSkip() throws UnsupportedEncodingException {
        JsonObject retrievedVehicle = this.tut.
                path("Vehicles").
                queryParam("$top", "2").
                queryParam("$skip", "1").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle " + retrievedVehicle);
        JsonValue value = retrievedVehicle.get("value");
        System.out.println("value = " + value);
    }

    //not implemented
    //@Test
    public void searchVehicles() throws UnsupportedEncodingException {
        JsonObject retrievedVehicle = this.tut.
                path("Vehicles").
                queryParam("$search", "Hirsch").
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("retrievedVehicle " + retrievedVehicle);
        JsonValue value = retrievedVehicle.get("value");
        System.out.println("value = " + value);
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
