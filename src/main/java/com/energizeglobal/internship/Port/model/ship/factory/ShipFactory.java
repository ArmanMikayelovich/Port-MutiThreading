package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ship.*;

public class ShipFactory {
    public Ship createClothesShip(Capacity capacity) {
        return new ClothesShip(capacity);
    }

    public Ship createFoodShip(Capacity capacity) {
        return new FoodShip(capacity);
    }

    public Ship createTechSip(Capacity capacity) {
        return new TechShip(capacity);
    }

}
