package com.energizeglobal.internship.Port.model.ship;

public enum Capacity {
    TEN(10), FIFTY(50), HUNDRED(100);

    private final int count;

    Capacity(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
