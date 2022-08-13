package com.nix.alextuleninov.task1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private int age;

    public void displayDataOfStudent(String name) {
        System.out.println("Name: " + name);
    }
}
