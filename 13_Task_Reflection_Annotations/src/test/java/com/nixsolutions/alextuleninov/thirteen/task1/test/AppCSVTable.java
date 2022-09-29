package com.nixsolutions.alextuleninov.thirteen.task1.test;

import com.nixsolutions.alextuleninov.thirteen.task1.mapping.PropertyKey;

public class AppCSVTable {

    @PropertyKey(0)
    public String name;

    @PropertyKey(1)
    public Sex sex;

    @PropertyKey(2)
    public int age;

    @PropertyKey(3)
    public long growth;

    @PropertyKey(4)
    public double weight;

    @PropertyKey(5)
    private boolean agreement;

    public boolean isAgreement() {
        return agreement;
    }

    enum Sex {
        MALE, FEMALE
    }

}
