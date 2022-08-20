/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task1;

/**
 * The Group class consists data about students and contract student
 * and consists method for display this data.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Group {
    private com.nixsolutions.alextuleninov.fourtask.task1.Student[] students;

    public void setStudents(com.nixsolutions.alextuleninov.fourtask.task1.Student[] students) {
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
        for (com.nixsolutions.alextuleninov.fourtask.task1.Student s : students) {
            if (s instanceof com.nixsolutions.alextuleninov.fourtask.task1.ContractStudent) {
                sb.append("Name: " + s.getName() + ", age: " + s.getAge()
                        + ", cost of contract: " + ((com.nixsolutions.alextuleninov.fourtask.task1.ContractStudent) s).getCost() + "\n");
            }
        }
        return sb.toString();
    }
}
