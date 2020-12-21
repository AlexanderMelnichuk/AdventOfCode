package ru.ama0.adventofcode.day17.cube;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class HSimulatorTest {
    @Test
    void name() throws IOException {
        Cube initCube = CubeReader.fromFile("/day17-test.txt");
        HSimulator simulator = new HSimulator(new HStrategy());

        HCube cube = new HCube(initCube);
        HCube next = cube;
        for (int i = 0; i < 6; i++) {
            next = simulator.simulate(cube);
            cube = next;
        }

        System.out.println(next);

        System.out.println(next.getCount());
    }



}