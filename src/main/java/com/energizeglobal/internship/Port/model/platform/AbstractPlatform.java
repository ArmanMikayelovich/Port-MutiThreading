package com.energizeglobal.internship.Port.model.platform;

import com.energizeglobal.internship.Port.exception.NonComplianceException;
import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;
import com.energizeglobal.internship.Port.model.ship.Ship;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractPlatform implements Platform {
    private static final int STANDARD_LOAD_COUNT = 10;

    private static final Logger log = Logger.getLogger(AbstractPlatform.class);
    private static final AtomicInteger index = new AtomicInteger(0);

    protected int id;
    private volatile Ship ship;
    private final ProductType productType;
    private String name;
    private Tunnel tunnel;

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public AbstractPlatform(ProductType productType, Tunnel tunnel) {
        this.productType = productType;
        this.tunnel = tunnel;
        this.id = index.getAndIncrement();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void enterToPlatform(Ship ship) {
        this.tunnel.enter(ship);
        loadShip(ship);

    }

    private void loadShip(Ship ship) {
        this.ship = ship;
        executor.submit(getRunnable());
    }

    public Runnable getRunnable() {
        return () -> {
            if (this.productType != ship.getProductType()) {
                throw new NonComplianceException("Unable the serve the ship, because product types are not matches.");
            }

            log.debug("Platform " + this.id + ": loading products to ship " + ship);
            while (ship.getLoad() <= ship.getCapacity() - STANDARD_LOAD_COUNT) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Thread interrupted");
                }
                ship.load(STANDARD_LOAD_COUNT);

            }
            log.debug(this.toString() + ":  Served ship " + ship);
        };
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        AbstractPlatform that = (AbstractPlatform) other;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
