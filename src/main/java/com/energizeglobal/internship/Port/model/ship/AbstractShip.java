package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.exception.OverloadException;
import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.platform.Platform;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractShip implements Ship {
    protected ProductType productType;
    private static final Logger log = Logger.getLogger(AbstractShip.class);
    private static AtomicInteger index = new AtomicInteger(0);

    private Capacity capacity;
    private int loadCount;
    protected int id;


    @Override
    public void goToPlatform(Platform platform) {
        log.info("Ship " + this + " tries to enter to platform " + platform);
        Runnable runnable = () -> platform.enterToPlatform(this);
        Thread thread = new Thread(runnable);
        thread.setName(String.valueOf(id));
        thread.start();
    }

    public AbstractShip(Capacity capacity) {
        this.capacity = capacity;
        this.id = index.getAndIncrement();
    }

    @Override
    public void load(int count) {
        log.info(this + ": loading " + count + " piece of product");
        if (this.loadCount + count > capacity.getCount()) {
            log.error("Ship " + this + " can't load too much: capacity - " + this.capacity.getCount() +
                    ", load - " + loadCount + ", want to load - " + count);
            throw new OverloadException("Can't load too much");
        }
        this.loadCount += count;
    }

    @Override
    public int getLoad() {
        return this.loadCount;
    }

    @Override
    public int getCapacity() {
        return this.capacity.getCount();
    }

    public ProductType getProductType() {
        return productType;
    }
}
