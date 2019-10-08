
package com.airhacks.ojpa.vehicles.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Vehicle.findAll, query = "SELECT v from Vehicle v")
public class Vehicle {

    public static final String PREFIX = "com.airhacks.ojpa.vehicles.entity.Vehicle.";
    public static final String findAll = PREFIX + "findAll";

    @Id
    private String vin;
    private String name;

    public Vehicle(String vin, String name) {
        this.vin = vin;
        this.name = name;
    }

    public Vehicle() {
    }

    public String getVin() {
        return vin;
    }

    public String getName() {
        return name;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder().
                add("vin", this.vin).
                add("name", this.name).
                build();
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vin=" + vin + ", name=" + name + '}';
    }
}
