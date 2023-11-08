package org.willowsenator.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void vehicleTest(){
        var car = new Car();
        var truck = new Truck();

        assertInstanceOf(Vehicle.class, car);
        assertInstanceOf(Vehicle.class, truck);
    }

    @Test
    void drive(){
        var car = new Car();
        var truck = new Truck();

        assertInstanceOf(Vehicle.class, car);
        assertInstanceOf(Vehicle.class, truck);

        assertEquals("CAR", car.drive());
        assertEquals("TRUCK", truck.drive());
    }
}