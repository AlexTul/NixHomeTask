package com.nixsolutions.alextuleninov.thirteen.task1.parsing;

import com.nixsolutions.alextuleninov.thirteen.task1.io.FileInputReader;

import java.nio.file.Path;
import java.util.*;

import static java.lang.System.out;

public final class CSVParser implements Parser {

    public CSVTable run() {

        var scanner = new Scanner(System.in);

        Path path = getPath(scanner);

        return parse(path);

    }

    private static Path getPath(Scanner scanner) {
        out.println("Input path to input file: ");
        return Path.of(scanner.nextLine());
    }

    @Override
    public CSVTable parse(Path path) {

        List<String> lines = new FileInputReader(path).read();;

        List<List<String>> csvTable = new ArrayList<>();
        for (String s : lines) {
            csvTable.add(List.of(s.split(";")));
        }

        return new CSVTable(csvTable);
    }


}
