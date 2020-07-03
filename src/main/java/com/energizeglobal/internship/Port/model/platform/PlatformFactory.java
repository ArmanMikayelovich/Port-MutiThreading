package com.energizeglobal.internship.Port.model.platform;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;

public class PlatformFactory {

    public Platform createPlatform(ProductType type, Tunnel tunnel) {

        switch (type) {
            case FOOD: {
                return new Platform(ProductType.FOOD, tunnel);
            }
            case TECH: {
                return new Platform(ProductType.TECH, tunnel);
            }
            case CLOTHES: {
                return new Platform(ProductType.CLOTHES, tunnel);
            }
            default: {
                throw new RuntimeException("Invalid platform type");
            }
        }
    }
}
