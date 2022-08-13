/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nix.alextuleninov.task1;

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

    public ContractStudent(String name, double cost) {
        super.setName(name);
        this.cost = cost;
    }

    /**
     * This method displays data about an object of class Student.
     *
     * @param name          student's name
     * @return              displays data about an object of class Student
     * */
    @Override
    public String displayDataOfStudent(String name) {
        return"Name: " + name + ", cost of contract: " + this.getCost() + "\n";
    }
}
