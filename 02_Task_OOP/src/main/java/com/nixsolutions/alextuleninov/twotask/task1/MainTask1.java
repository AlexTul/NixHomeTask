/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.fourtask.task1;

/**
 * The MainTask1 class consists data about students and contract student
 * and displays this data.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class MainTask1 {
    public static void main(String[] args) {
        com.nixsolutions.alextuleninov.fourtask.task1.Group gr = new com.nixsolutions.alextuleninov.fourtask.task1.Group();

        com.nixsolutions.alextuleninov.fourtask.task1.Student st = new com.nixsolutions.alextuleninov.fourtask.task1.Student();
        st.setName("Petr");
        st.setAge(20);

        gr.setStudents(new com.nixsolutions.alextuleninov.fourtask.task1.Student[]{st,
                new com.nixsolutions.alextuleninov.fourtask.task1.ContractStudent("Kate", 21, 2000),
                new com.nixsolutions.alextuleninov.fourtask.task1.ContractStudent("James", 20, 2100)});

        System.out.println(gr.toString());
    }
}