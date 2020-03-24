package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.model.ProductType;

public class TechShip extends AbstractShip {
    public TechShip(Capacity capacity) {
        super(capacity);
        this.productType = ProductType.TECH;
    }

    @Override
    public String toString() {
        return "{ TechShip: " + this.id + " [ capacity: " + getCapacity() + ", loadCount:  " + getLoad() + " ] } ";
    }
}
