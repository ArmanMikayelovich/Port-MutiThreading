package com.energizeglobal.internship.Port.model.platform;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;

import java.util.concurrent.atomic.AtomicInteger;

public class ClothesPlatform extends AbstractPlatform {
    private static final AtomicInteger index = new AtomicInteger(0);

    public ClothesPlatform(ProductType productType, Tunnel tunnel) {
        super(productType, tunnel);
        setName("Food Platform: " + index.getAndIncrement());
    }


    @Override
    public String toString() {
        return "{ Clothes Platform: " + this.id + " } ";
    }
}
