package ru.ama0.adventofcode.y2021.day20.infrastructure;

import lombok.Getter;
import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day20.domain.Image;
import ru.ama0.adventofcode.y2021.day20.domain.PixelType;

import java.io.IOException;
import java.util.stream.Collectors;

public class ImageRepositoryImpl implements ru.ama0.adventofcode.y2021.day20.application.ports.ImageRepository {

    @Getter
    private String algorithm;
    @Getter
    private Image image;

    public void init(String filename) throws IOException {
        var lines = Io.readLines(filename);

        algorithm = lines.stream().takeWhile(line -> !line.isBlank())
                .collect(Collectors.joining());

        image = new Image(PixelType.DARK,
                lines.stream()
                .dropWhile(line -> !line.isBlank())
                .dropWhile(String::isBlank)
                .toArray(String[]::new));
    }

}
