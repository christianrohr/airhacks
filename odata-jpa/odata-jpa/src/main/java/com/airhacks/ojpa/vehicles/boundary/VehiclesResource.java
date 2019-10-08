
package com.airhacks.ojpa.vehicles.boundary;

import com.airhacks.ojpa.vehicles.entity.Vehicle;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehiclesResource {

    @Inject
    VehiclesGarage garage;

    @GET
    public JsonArray vehicles() {

        return this.garage.vehicles().
                stream().
                map(Vehicle::toJSON).
                collect(JsonCollectors.toJsonArray());
    }

    @POST
    public void create(Vehicle vehicle) {
        this.garage.create(vehicle);
    }



}
