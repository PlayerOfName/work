package org.shvetsov.avia;

public class PassengerPlane extends Aircraft implements Passenger {
    private final int passengerCapacity;
    private final int runwayLength;

    public PassengerPlane(String registrationNumber, int passengerCapacity, int runwayLength) {
        super(registrationNumber);
        this.passengerCapacity = passengerCapacity;
        this.runwayLength = runwayLength;
    }

    @Override
    public String getAircraftType() {
        return "Пассажирский самолет";
    }

    @Override
    public String getDetails() {
        return passengerCapacity + " пассажиров - полоса " + runwayLength + " метров";
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}
