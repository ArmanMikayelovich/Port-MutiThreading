package com.energizeglobal.internship.Port.model.ship;

import com.energizeglobal.internship.Port.model.ProductType;
import com.energizeglobal.internship.Port.model.Tunnel;
import com.energizeglobal.internship.Port.model.platform.Platform;

public interface Ship {
    int getLoad();


    void goToPlatform(Platform platform);

    void load(int count);

    int getCapacity();

    ProductType getProductType();
}
