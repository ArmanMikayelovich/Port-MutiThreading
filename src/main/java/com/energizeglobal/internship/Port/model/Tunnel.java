package com.energizeglobal.internship.Port.model;

import com.energizeglobal.internship.Port.model.ship.Ship;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel {
    private static final Logger log = Logger.getLogger(Tunnel.class);
    private static final int SHIP_CAPACITY = 5;
    private volatile AtomicInteger shipCount = new AtomicInteger(0);

    public void enter(Ship ship) {
        log.info(ship + " tries to enter to " + this + ": " + LocalDateTime.now());
        while (!this.canEnter()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("Thead " + Thread.currentThread().getName() + Thread.currentThread().getId() +
                        " Interrupted \n " +
                        "Exception: " + e);
                throw new RuntimeException("Thread interrupted");
            }
        }
        goThrough(ship);
    }

    private synchronized boolean canEnter() {
        log.info(this + " : " + LocalDateTime.now());
        return this.shipCount.get() < SHIP_CAPACITY;
    }

    private void goThrough(Ship ship) {
        this.shipCount.incrementAndGet();
        log.info("Ship " + ship + " Entered to tunnel " + this + " : " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted");
        }
        shipCount.decrementAndGet();
    }


    @Override
    public String toString() {
        return "{ Tunnel : [ capacity: " + SHIP_CAPACITY + ", ships in tunnel: " + shipCount + " ] } ";
    }

}



