package com.energizeglobal.internship.Port.model;

import com.energizeglobal.internship.Port.model.ship.Ship;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel {
    private static final Logger log = Logger.getLogger(Tunnel.class);
    private static final int SHIP_CAPACITY = 5;
    private volatile AtomicInteger shipCount = new AtomicInteger(0);
    private Semaphore semaphore = new Semaphore(SHIP_CAPACITY, true);

    public void enter(Ship ship) {
        log.info(ship + " tries to enter to " + this + ": " + LocalDateTime.now());
        try {
            semaphore.acquire();
            goThrough(ship);
            semaphore.release();
        } catch (InterruptedException exception) {
            String threadName = Thread.currentThread().getName();
            String message = exception.getMessage();
            log.error("Interrupted exception occurred in thread " + threadName + ": " + message);
        }

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



