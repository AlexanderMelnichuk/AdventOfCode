package ru.ama0.adventofcode.y2021.day20.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day20.application.ports.ImageRepository;
import ru.ama0.adventofcode.y2021.day20.domain.PixelType;
import ru.ama0.adventofcode.y2021.day20.domain.StepCalculator;

import java.util.Arrays;

@RequiredArgsConstructor
public class EnhancedImagePixelsCounter {

    private final ImageRepository repository;

    public long execute(int enhanceTimes) {
        var stepCalculator = new StepCalculator(repository.getAlgorithm());

        var image = repository.getImage();
        for (int i = 0; i < enhanceTimes; i++) {
            image = stepCalculator.enhance(image);
        }

        return Arrays.stream(image.getPixelLines())
                .flatMapToInt(String::chars)
                .filter(c -> c == PixelType.LIGHT)
                .count();
    }

}
