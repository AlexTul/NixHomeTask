package com.nixsolutions.alextuleninov.thirteen.task1.parsing;

import java.nio.file.Path;

public interface Parser {

    CSVTable parse(Path path);
    //CSVTable parse(Reader source);

}
