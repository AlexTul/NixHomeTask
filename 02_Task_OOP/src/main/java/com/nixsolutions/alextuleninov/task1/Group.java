/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.task1;

import lombok.extern.log4j.Log4j;

/**
 * The Group class consists data about students and contract student
 * and consists method for display this data.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Group {
    private Student[] students;

    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * This method displays data about an object of class Group.
     *
     * @return              displays data about an object of class Group
     * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            if (s instanceof ContractStudent) {
                sb.append("Name: " + s.getName() + ", age: " + s.getAge()
                        + ", cost of contract: " + ((ContractStudent) s).getCost() + "\n");
            }
        }
        return sb.toString();
    }
}
