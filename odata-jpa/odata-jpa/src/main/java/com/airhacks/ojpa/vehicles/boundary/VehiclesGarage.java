
package com.airhacks.ojpa.vehicles.boundary;

import com.airhacks.ojpa.vehicles.entity.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VehiclesGarage {

    @PersistenceContext(unitName = "jaxrs")
    EntityManager em;

    public void create(Vehicle vehicle) {
        this.em.merge(vehicle);
    }

    public List<Vehicle> vehicles() {
        return this.em.createNamedQuery(Vehicle.findAll, Vehicle.class).
                getResultList();
    }

}
