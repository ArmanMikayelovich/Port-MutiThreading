package com.energizeglobal.internship.Port.model.platform;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;

import java.util.concurrent.atomic.AtomicInteger;

public class TechPlatform extends AbstractPlatform {
    private static AtomicInteger index = new AtomicInteger(0);

    public TechPlatform(ProductType productType, Tunnel tunnel) {
        super(productType, tunnel);
        setName("Food Platform: " + index.getAndIncrement());
    }

    @Override
    public ProductType getServingProductType() {
        setName("Tech Platform: " + index.getAndIncrement());
        return ProductType.TECH;
    }

    @Override
    public String toString() {
        return "{ Tech  Platform: " + this.id + " } ";
    }
}
