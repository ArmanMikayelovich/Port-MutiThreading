package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.exception.OverloadException;
import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.platform.Platform;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship {
    private final ProductType productType;
    private static final Logger log = Logger.getLogger(Ship.class);
    private static final AtomicInteger index = new AtomicInteger(0);

    private final Capacity capacity;
    private int loadCount;
    private final int id;


    public Ship(Capacity capacity, ProductType productType) {
        this.capacity = capacity;
        this.productType = productType;
        this.id = index.getAndIncrement();
    }


    public void goToPlatform(Platform platform) {
        log.info("Ship " + this + " tries to enter to platform " + platform);
        Runnable runnable = () -> platform.enterToPlatform(this);
        Thread thread = new Thread(runnable);
        thread.setName(String.valueOf(id));
        thread.start();
    }


    public void load(int count) {
        log.info(this + ": loading " + count + " piece of product");
        if (this.loadCount + count > capacity.getCount()) {
            log.error("Ship " + this + " can't load too much: capacity - " + this.capacity.getCount() +
                    ", load - " + loadCount + ", want to load - " + count);
            throw new OverloadException("Can't load too much");
        }
        this.loadCount += count;
    }


    public int getLoad() {
        return this.loadCount;
    }

    public int getCapacity() {
        return this.capacity.getCount();
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Ship "+ this.id + ": " + this.productType.toString() + " ";
    }
}
