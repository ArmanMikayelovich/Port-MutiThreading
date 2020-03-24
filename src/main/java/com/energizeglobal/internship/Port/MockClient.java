package com.energizeglobal.internship.Port;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;
import com.energizeglobal.internship.Port.model.platform.Platform;
import com.energizeglobal.internship.Port.model.platform.PlatformFactory;
import com.energizeglobal.internship.Port.model.ship.Ship;
import com.energizeglobal.internship.Port.model.ship.factory.BigShipFactory;
import com.energizeglobal.internship.Port.model.ship.factory.MiddleShipFactory;
import com.energizeglobal.internship.Port.model.ship.factory.ShipFactory;
import com.energizeglobal.internship.Port.model.ship.factory.SmallShipFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MockClient {
    private static final Logger log = Logger.getLogger(MockClient.class);

    public static void main(String[] args) {
        ShipFactory bigShipFactory = new BigShipFactory();
        MiddleShipFactory middleShipFactory = new MiddleShipFactory();
        SmallShipFactory smallShipFactory = new SmallShipFactory();

        List<Ship> allShips = new ArrayList<>();
        allShips.addAll(createShips(bigShipFactory));
        allShips.addAll(createShips(middleShipFactory));
        allShips.addAll(createShips(smallShipFactory));

        test(allShips);

    }

    public static List<Ship> createShips(ShipFactory shipFactory) {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(shipFactory.createClothesShip());
        ships.add(shipFactory.createClothesShip());
        ships.add(shipFactory.createClothesShip());

        ships.add(shipFactory.createFoodShip());
        ships.add(shipFactory.createFoodShip());
        ships.add(shipFactory.createFoodShip());
        ships.add(shipFactory.createFoodShip());
        ships.add(shipFactory.createFoodShip());

        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        ships.add(shipFactory.createTechSip());
        log.info("Created " + ships.size() + " ships");
        return ships;
    }

    public static List<Platform> createPlatforms(PlatformFactory platformFactory, Tunnel tunnel) {
        ArrayList<Platform> platforms = new ArrayList<>();
        platforms.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.CLOTHES, tunnel));

        platforms.add(platformFactory.createPlatform(ProductType.FOOD, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.FOOD, tunnel));

        platforms.add(platformFactory.createPlatform(ProductType.TECH, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.TECH, tunnel));
        platforms.add(platformFactory.createPlatform(ProductType.TECH, tunnel));

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
                }
                case FOOD: {
                    ship.goToPlatform(platformList.get(1));
                }
                case TECH: {
                    ship.goToPlatform(platformList.get(2));
                }
            }
        }
    }
}
