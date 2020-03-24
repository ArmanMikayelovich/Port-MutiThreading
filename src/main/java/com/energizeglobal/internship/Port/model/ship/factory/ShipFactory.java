package com.energizeglobal.internship.Port.model.ship.factory;

import com.energizeglobal.internship.Port.model.ship.Ship;

public interface ShipFactory {
    Ship createClothesShip();

    Ship createFoodShip();

    Ship createTechSip();
}
