package org.shvetsov.avia;

public class PassengerHelicopter extends Aircraft implements Passenger {
    private final int passengerCapacity;
    private final double rotorSize;


    public PassengerHelicopter(String registrationNumber, int passengerCapacity, double rotorSize) {
        super(registrationNumber);
        this.passengerCapacity = passengerCapacity;
        this.rotorSize = rotorSize;
    }

    @Override
    public String getAircraftType() {
        return "Пассажирский вертолёт";
    }

    @Override
    public String getDetails() {
        return passengerCapacity + " пассажиров - размер винта " + rotorSize + " метров";
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}
