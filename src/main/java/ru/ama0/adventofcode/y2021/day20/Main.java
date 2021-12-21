package ru.ama0.adventofcode.y2021.day20;

import ru.ama0.adventofcode.y2021.day20.application.EnhancedImagePixelsCounter;
import ru.ama0.adventofcode.y2021.day20.infrastructure.ImageRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new ImageRepositoryImpl();
        repository.init("/2021/input20.txt");
        var enhancedImagePixelCounter = new EnhancedImagePixelsCounter(repository);

        var twoEnhancementsPixelCount = enhancedImagePixelCounter.execute(2);
        System.out.println(twoEnhancementsPixelCount);

        var fiftyEnhancementsPixelCount = enhancedImagePixelCounter.execute(50);
        System.out.println(fiftyEnhancementsPixelCount);
    }
}
