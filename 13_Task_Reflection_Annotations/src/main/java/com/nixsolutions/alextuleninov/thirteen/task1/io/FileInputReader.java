/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.thirteen.task1.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * The FileInputReader class reads the lines of a file.
 * */
public final class FileInputReader implements InputReader {

    private final Path path;

    public FileInputReader(Path path) {
        this.path = Objects.requireNonNull(path, "Path can't be null");
    }

    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
