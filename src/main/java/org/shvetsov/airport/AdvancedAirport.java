package org.shvetsov.airport;

import org.shvetsov.avia.*;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedAirport {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        Airport airport = new Airport();
        Random random = new Random();

        List<Aircraft> aircrafts = new ArrayList<>();

        aircrafts.add(new PassengerPlane("PAX-001", 215, 2100));
        aircrafts.add(new PassengerPlane("PAX-002", 180, 1900));

        aircrafts.add(new CargoPlaneAdaptive("CAR-101", 50, 2300, CargoType.EQUIPMENT, airport));
        aircrafts.add(new CargoPlaneAdaptive("CAR-102", 30, 2200, CargoType.MEDICINE, airport));

        for (Aircraft aircraft : aircrafts) {
            if (aircraft instanceof Runnable) {
                new Thread((Runnable)aircraft).start();
            }

            try {
                Thread.sleep(random.nextInt(1500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Thread.sleep(30000);
            airport.shutdown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
