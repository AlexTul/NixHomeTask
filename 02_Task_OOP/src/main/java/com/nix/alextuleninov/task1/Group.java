/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nix.alextuleninov.task1;

import lombok.extern.log4j.Log4j;

/**
 * The Group class consists data about students and contract student
 * and displays this data.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
@Log4j
public class Group {

    public static void main(String[] args) {
        Student[] students = new Student[3];

        Student st = new Student();
        st.setName("Petr");
        st.setAge(20);

        ContractStudent cS = new ContractStudent("Kate", 2000);
        ContractStudent cS1 = new ContractStudent("James", 2100);

        students[0] = st;
        students[1] = cS;
        students[2] = cS1;

        log.info(students[1].displayDataOfStudent(cS.getName()));
        log.info(students[2].displayDataOfStudent(cS1.getName()));
    }
}
