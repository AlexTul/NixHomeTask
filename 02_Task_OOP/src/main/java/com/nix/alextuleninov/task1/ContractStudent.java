package com.nix.alextuleninov.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractStudent extends Student {
    private double cost;

    public ContractStudent(String name, double cost) {
        super.setName(name);
        this.cost = cost;
    }

    public void displayDataOfStudent(double cost) {
        System.out.println("Cost of contract: " + cost);
    }

    public static void displayNameCostOfStudent(String name, double cost) {
        System.out.println("Name: " + name + ", cost of contract: " + cost);
    }
}
