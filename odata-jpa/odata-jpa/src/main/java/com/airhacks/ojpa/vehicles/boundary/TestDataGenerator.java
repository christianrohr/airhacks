
package com.airhacks.ojpa.vehicles.boundary;

import com.airhacks.ojpa.vehicles.entity.Vehicle;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class TestDataGenerator {
    
    @Inject
    VehiclesGarage garage;

    @PostConstruct
    public void init() {
        System.out.println("---- data generation ----");
        Stream.generate(System::nanoTime).
                limit(10).
                map(number -> "id: " + number).
                map(id -> new Vehicle(id, "pickup " + id)).
                peek(System.out::println).
                forEach(v -> this.garage.create(v));
        this.garage.create(new Vehicle("42", "Hans Hirsch"));
    }

}
