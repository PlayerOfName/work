package org.shvetsov.airport;

import org.shvetsov.avia.CargoPlane;

public class CargoPlaneAdaptive extends CargoPlane implements Runnable {
    private final CargoType cargoType;
    private final Airport airport;

    public CargoPlaneAdaptive(String registrationNumber, double capacity, int runwayLength, CargoType type, Airport airport) {
        super(registrationNumber, capacity, runwayLength);
        this.cargoType = type;
        this.airport = airport;
    }

    public CargoType getCargoType() { return cargoType; }

    @Override
    public void run() {
        try {
            airport.land(this);
            airport.unload(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
