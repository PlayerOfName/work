package org.shvetsov;

public class HomeSingleton {

    private static HomeSingleton instance;

    private HomeSingleton () { }

    public static HomeSingleton getInstance() {
        if (instance == null) {
            instance = new HomeSingleton();
        }
        return instance;
    }
}
