package org.shvetsov.avia;

public class CargoPlane extends Aircraft implements Cargo {
    private final double cargoCapacity;
    private final int runwayLength;

    public CargoPlane(String registrationNumber, double cargoCapacity, int runwayLength) {
        super(registrationNumber);
        this.cargoCapacity = cargoCapacity;
        this.runwayLength = runwayLength;
    }

    @Override
    public String getAircraftType() {
        return "Грузовой самолет";
    }

    @Override
    public String getDetails() {
        return cargoCapacity + " тонн - полоса " + runwayLength + " метров";
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }
}
