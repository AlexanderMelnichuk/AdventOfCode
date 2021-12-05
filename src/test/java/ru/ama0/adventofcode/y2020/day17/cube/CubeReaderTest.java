package ru.ama0.adventofcode.y2020.day17.cube;

import org.junit.jupiter.api.Test;

class CubeReaderTest {
    @Test
    void fromFile_day17test() throws Exception {
        Cube cube = CubeReader.fromFile("/day17-test.txt");

        System.out.println(cube);
    }
}
