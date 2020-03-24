package com.energizeglobal.internship.Port.model.platform;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;

public class PlatformFactory {

    public Platform createPlatform(ProductType type, Tunnel tunnel) {

        switch (type) {
            case FOOD: {
                return new FoodPlatform(ProductType.FOOD, tunnel);
            }
            case TECH: {
                return new TechPlatform(ProductType.TECH, tunnel);
            }
            case CLOTHES: {
                return new ClothesPlatform(ProductType.CLOTHES, tunnel);
            }
            default: {
                throw new RuntimeException("Invalid platform type");
            }
        }
    }
}
