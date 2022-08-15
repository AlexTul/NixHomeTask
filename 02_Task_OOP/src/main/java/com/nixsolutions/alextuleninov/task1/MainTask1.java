/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.task1;

/**
 * The MainTask1 class consists data about students and contract student
 * and displays this data.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class MainTask1 {
    public static void main(String[] args) {
        Group gr = new Group();

        Student st = new Student();
        st.setName("Petr");
        st.setAge(20);

        gr.setStudents(new Student[]{st,
                new ContractStudent("Kate", 21, 2000),
                new ContractStudent("James", 20, 2100)});

        gr.toString();
    }
}