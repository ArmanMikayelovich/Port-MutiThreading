package com.energizeglobal.internship.Port;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;
import com.energizeglobal.internship.Port.model.platform.Platform;
import com.energizeglobal.internship.Port.model.platform.PlatformFactory;
import com.energizeglobal.internship.Port.model.ship.Capacity;
import com.energizeglobal.internship.Port.model.ship.Ship;
import com.energizeglobal.internship.Port.model.ship.factory.ShipFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MockClient {
    private static final Logger log = Logger.getLogger(MockClient.class);

    public static void main(String[] args) {
        ShipFactory shipFactory = new ShipFactory();
        List<Ship> allShips = new ArrayList<>(createShips(shipFactory));
        test(allShips);

    }

    public static List<Ship> createShips(ShipFactory shipFactory) {
        ArrayList<Ship> ships = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            ships.add(shipFactory.createClothesShip(Capacity.FIFTY));
        }
        for (int x = 0; x < 6; x++) {
            ships.add(shipFactory.createFoodShip(Capacity.HUNDRED));
        }

        for (int x = 0; x < 8; x++) {
            ships.add(shipFactory.createTechSip(Capacity.TEN));
        }
        log.info("Created " + ships.size() + " ships");
        return ships;
    }

    public static List<Platform> createPlatforms(PlatformFactory platformFactory, Tunnel tunnel) {
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            platforms.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));
        }
        for (int x = 0; x < 2; x++) {
            platforms.add(platformFactory.createPlatform(ProductType.FOOD, tunnel));
        }

        for (int x = 0; x < 3; x++) {
            platforms.add(platformFactory.createPlatform(ProductType.TECH, tunnel));
        }
        log.debug("Created " + platforms.size() + " platforms");
        return platforms;
    }

    private static void test(List<Ship> ships) {
        Tunnel tunnel = new Tunnel();
        List<Platform> platformList = new ArrayList<>();
        PlatformFactory platformFactory = new PlatformFactory();
        platformList.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));
        platformList.add(platformFactory.createPlatform(ProductType.FOOD, tunnel));
        platformList.add(platformFactory.createPlatform(ProductType.TECH, tunnel));

        for (Ship ship : ships) {
            switch (ship.getProductType()) {
                case CLOTHES: {
                    ship.goToPlatform(platformList.get(0));
                    break;
                }
                case FOOD: {
                    ship.goToPlatform(platformList.get(1));
                    break;
                }
                case TECH: {
                    ship.goToPlatform(platformList.get(2));
                    break;
                }
            }
        }
    }
}
