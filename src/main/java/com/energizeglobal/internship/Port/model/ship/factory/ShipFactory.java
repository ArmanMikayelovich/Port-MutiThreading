package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.ship.*;

public class ShipFactory {
    public Ship createClothesShip(Capacity capacity) {
        return new Ship(capacity, ProductType.CLOTHES);
    }

    public Ship createFoodShip(Capacity capacity) {
        return new Ship(capacity,ProductType.FOOD);
    }

    public Ship createTechSip(Capacity capacity) {
        return new Ship(capacity,ProductType.TECH);
    }

}
