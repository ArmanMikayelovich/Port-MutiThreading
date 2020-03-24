package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.model.ProductType;

public class FoodShip extends AbstractShip {
    public FoodShip(Capacity capacity) {
        super(capacity);
        this.productType = ProductType.FOOD;

    }

    @Override
    public String toString() {
        return "{ FoodShip: " + this.id + " [ capacity: " + getCapacity() + ", loadCount:  " + getLoad() + " ] } ";
    }
}
