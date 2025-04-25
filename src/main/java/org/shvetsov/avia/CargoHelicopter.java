package org.shvetsov.avia;

public class CargoHelicopter extends Aircraft implements Cargo {
    private final double cargoCapacity;
    private final double rotorSize;

    public CargoHelicopter(String registrationNumber, double cargoCapacity, double rotorSize) {
        super(registrationNumber);
        this.cargoCapacity = cargoCapacity;
        this.rotorSize = rotorSize;
    }

    @Override
    public String getAircraftType() {
        return "Грузовой вертолёт";
    }

    @Override
    public String getDetails() {
        return cargoCapacity + " тонн - размер винта " + rotorSize + " метров";
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }
}
