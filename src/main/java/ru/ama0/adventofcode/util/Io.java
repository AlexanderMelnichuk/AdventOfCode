package ru.ama0.adventofcode.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;

@UtilityClass
public class Io {
    public static List<String> readLines(String fileName) throws IOException {
        return IOUtils.readLines(Io.class.getResourceAsStream(fileName));
    }

}
