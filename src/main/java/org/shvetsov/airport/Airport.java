package org.shvetsov.airport;

import org.shvetsov.avia.Aircraft;
import org.shvetsov.avia.CargoPlane;
import org.shvetsov.avia.PassengerPlane;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.*;

public class Airport {
    private final Semaphore runway = new Semaphore(1);
    private final ExecutorService terminalService = Executors.newFixedThreadPool(3);
    private final Map<CargoType, BlockingQueue<CargoPlaneAdaptive>> cargoTerminals = new EnumMap<>(CargoType.class);
    private final BlockingQueue<PassengerPlane> passengerTerminal = new LinkedBlockingQueue<>();

    public Airport() {
        for (CargoType type : CargoType.values()) {
            cargoTerminals.put(type, new LinkedBlockingQueue<>());
        }
    }

    public void land(Aircraft aircraft) throws InterruptedException {
        System.out.println(aircraft + " запрашивает посадку");
        runway.acquire();

        try {
            System.out.println(aircraft + " начал посадку");
            Thread.sleep(1000);
            System.out.println(aircraft + " приземлился");
        } finally {
            runway.release();
        }
    }

    public void unload(CargoPlaneAdaptive plane) throws InterruptedException {
        System.out.println(plane + " направляется в грузовой терминал");
        cargoTerminals.get(plane.getCargoType()).put(plane);

        terminalService.submit(() -> {
            try {
                System.out.println(plane + " начал разгрузку");
                int time = (int)(plane.getCargoCapacity() / 10) * 1000;
                Thread.sleep(time);
                System.out.println(plane + " разгружен за " + (time/1000) + " сек");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void processPassengerPlane(PassengerPlane plane) throws InterruptedException {
        System.out.println(plane + " направляется к пассажирскому терминалу");
        passengerTerminal.put(plane);

        terminalService.submit(() -> {
            try {
                System.out.println("Высадка " + plane.getPassengerCapacity() + " пассажиров");
                Thread.sleep(2000);
                System.out.println(plane + " завершил высадку");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdown() {
        terminalService.shutdown();
    }
}
