package com.nix.alextuleninov.task1;

public class Group {
    static Student[] students;

    public static void displayNameCostOfStudent(Student[] students, double[] cost) {
        for (int i = 0; i < students.length; i++) {
            ContractStudent.displayNameCostOfStudent(students[i].getName(), cost[i]);
        }
    }

    public static void displayDataOfStudent(double cost) {
        System.out.println("Cost of contract: " + cost);
    }


    public static void main(String[] args) {
        ContractStudent cs0 = new ContractStudent("Petya", 2000);
        ContractStudent cs1 = new ContractStudent("Ira", 2100);
        ContractStudent cs2 = new ContractStudent("Gosha", 2050);

        students[0].setName("Vasya");
        students[1].setName("Peta");
        students[2].setName("Tanya");

        System.out.println(students[0]);




    }
}
