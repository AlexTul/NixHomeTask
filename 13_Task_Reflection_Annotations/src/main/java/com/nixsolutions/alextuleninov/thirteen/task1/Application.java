package com.nixsolutions.alextuleninov.thirteen.task1;

import com.nixsolutions.alextuleninov.thirteen.task1.mapping.AppCSVTable;
import com.nixsolutions.alextuleninov.thirteen.task1.mapping.CSVMapper;
import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVParser;
import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;

import java.util.List;

import static java.lang.System.out;

public class Application {

    public static void main(String[] args) {

        // C:\Users\Дом\IdeaProjects\NixHomeTask\13_Task_Reflection_Annotations\example\magazine.csv
        CSVTable csvTable = new CSVParser().run();

        CSVMapper csvMapper = new CSVMapper();


        List<AppCSVTable> appCSVTable = csvMapper.map(csvTable, AppCSVTable.class);

        out.println("name: " + appCSVTable.get(0).name);
        //out.println("sex: " + appCSVTable.get(0).sex);
        out.println("age: " + appCSVTable.get(0).age);
        out.println("growth: " + appCSVTable.get(0).growth);
        out.println("weight: " + appCSVTable.get(0).weight);
        out.println("weight: " + appCSVTable.get(0).weight);
        out.println("agreement: " + appCSVTable.get(0).agreement);

    }

}
