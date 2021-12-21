package ru.ama0.adventofcode.y2021.day20.domain;

import com.google.common.base.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day20.infrastructure.ImageRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StepCalculatorTest {

    private ImageRepositoryImpl repository;
    private StepCalculator stepCalculator;

    @BeforeEach
    void setUp() throws IOException {
        repository = new ImageRepositoryImpl();
        repository.init("/2021/input20test.txt");
        stepCalculator = new StepCalculator(repository.getAlgorithm());
    }

    @Test
    void expand() {
        stepCalculator = new StepCalculator(Strings.repeat("#", 512));
        var image = new Image(PixelType.LIGHT, new String[]{ "#.#", ".#." });

        var expanded = stepCalculator.expand(image);

        assertThat(expanded.getInfinityFiller()).isEqualTo(image.getInfinityFiller());
        assertThat(expanded.getPixelLines()).containsExactly(
                "#######",
                "#######",
                "###.###",
                "##.#.##",
                "#######",
                "#######"
        );
    }

    @Test
    void enhance_valid_valid() {
        var enhancedImage = stepCalculator.enhance(repository.getImage());

        assertThat(enhancedImage.getPixelLines()).containsExactly(
                ".........",
                "..##.##..",
                ".#..#.#..",
                ".##.#..#.",
                ".####..#.",
                "..#..##..",
                "...##..#.",
                "....#.#..",
                "........."
        );
    }
}