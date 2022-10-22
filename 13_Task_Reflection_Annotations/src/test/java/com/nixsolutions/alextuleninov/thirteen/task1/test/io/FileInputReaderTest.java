package com.nixsolutions.alextuleninov.thirteen.task1.test.io;

import com.nixsolutions.alextuleninov.thirteen.task1.io.FileInputReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileInputReaderTest {

    private static List<String> expected;

    @BeforeAll
    static void init() {
        expected = new ArrayList();
        expected.add("name,sex,age,growth,weight,agreement");
        expected.add("Jorg,MALE,21,180,96.5,true");
        expected.add("Piter,MALE,22,182,98.5,false");
        expected.add("Lisa,FEMALE,19,170,53.2,true");
    }

    @AfterAll
    static void clean() {
        expected = null;
    }

    @Test
    void read() throws URISyntaxException {
        //Path path = Path.of("src/test/resources/magazine.csv");
        Path path = Paths.get(getClass().getResource("/magazine.csv").toURI());

        FileInputReader inputReader = new FileInputReader(path);

        List<String> actual = inputReader.read();

        assertEquals(expected , actual);

    }

}
