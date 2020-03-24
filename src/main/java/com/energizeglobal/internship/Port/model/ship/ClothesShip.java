package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.model.ProductType;

import java.util.concurrent.atomic.AtomicInteger;

public class ClothesShip extends AbstractShip {
    private static AtomicInteger index = new AtomicInteger(0);

    public ClothesShip(Capacity capacity) {
        super(capacity);
        this.productType = ProductType.CLOTHES;

    }

    @Override
    public String toString() {
        return "{ ClothesShip: " + this.id + " [ capacity: "+  getCapacity() + ", loadCount:  " + getLoad() + " ] } ";
    }
}
