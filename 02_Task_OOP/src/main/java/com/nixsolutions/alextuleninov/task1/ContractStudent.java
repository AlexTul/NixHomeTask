/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.task1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * The ContractStudent class consists data about contract student.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
@Log4j
@Getter
@Setter
public class ContractStudent extends Student {
    private double cost;

    public ContractStudent(String name, int age, double cost) {
        super.setName(name);
        super.setAge(age);
        this.cost = cost;
    }

    /**
     * This method displays data about an object of class Student.
     *
     * @return              displays data about an object of class Student
     * */
    @Override
    public String displayDataOfStudent() {
        return"Name: " + getName() + ", age: " + getAge() + ", cost of contract: " + getCost() + "\n";
    }
}
