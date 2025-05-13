package org.shvetsov;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class IdentityClass {
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private final int id;

    public IdentityClass() {
        this.id = nextId.getAndIncrement();
    }

    public int getId() {
        return id;
    }
}
