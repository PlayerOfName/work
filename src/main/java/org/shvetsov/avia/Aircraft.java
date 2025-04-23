package org.shvetsov.avia;

public abstract class Aircraft {
    private final String registrationNumber;

    Aircraft(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract String getAircraftType();
    public abstract String getDetails();

    @Override
    public String toString() {
        return registrationNumber + " - " + getAircraftType() + " - " + getDetails();
    }
}
