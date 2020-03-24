package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ship.*;

public class MiddleShipFactory implements ShipFactory {
    @Override
    public Ship createClothesShip() {
        return new ClothesShip(Capacity.FIFTY);
    }

    @Override
    public Ship createFoodShip() {
        return new FoodShip(Capacity.FIFTY);
    }

    @Override
    public Ship createTechSip() {
        return new TechShip(Capacity.FIFTY);
    }
}
