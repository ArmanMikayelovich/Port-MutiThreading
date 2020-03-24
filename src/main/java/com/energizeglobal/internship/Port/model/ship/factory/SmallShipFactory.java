package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ship.*;

public class SmallShipFactory implements ShipFactory {
    @Override
    public Ship createClothesShip() {
        return new ClothesShip(Capacity.TEN);
    }

    @Override
    public Ship createFoodShip() {
        return new FoodShip(Capacity.TEN);
    }

    @Override
    public Ship createTechSip() {
        return new TechShip(Capacity.TEN);
    }
}