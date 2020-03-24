package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ship.*;

public class BigShipFactory implements ShipFactory {

    @Override
    public Ship createClothesShip() {
        return new ClothesShip(Capacity.HUNDRED);
    }

    @Override
    public Ship createFoodShip() {
        return new FoodShip(Capacity.HUNDRED);

    }

    @Override
    public Ship createTechSip() {
        return new TechShip(Capacity.HUNDRED);
    }
}
