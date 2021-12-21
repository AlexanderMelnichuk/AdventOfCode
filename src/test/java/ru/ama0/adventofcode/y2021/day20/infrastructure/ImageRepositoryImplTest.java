package ru.ama0.adventofcode.y2021.day20.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ImageRepositoryImplTest {

    private ImageRepositoryImpl repository;

    @BeforeEach
    void setUp() throws IOException {
        repository = new ImageRepositoryImpl();
        repository.init("/2021/input20test.txt");
    }

    @Test
    void init_validAlgorithm_valid() {
        var algorithm = repository.getAlgorithm();

        assertThat(algorithm).isEqualTo("..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##" +
                "#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###" +
                ".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#." +
                ".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#....." +
                ".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.." +
                "...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#....." +
                "..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#");
    }

    @Test
    void init_validImage_valid() {
        var image = repository.getImage();

        assertThat(image.getPixelLines()).containsExactly(
                "#..#.",
                "#....",
                "##..#",
                "..#..",
                "..###");
    }

}