package ru.ama0.adventofcode.y2020.day17.cube;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class SimulatorTest {

    @Test
    void simulate_day17test() throws IOException {
        Cube cube = CubeReader.fromFile("/2020/day17-test.txt");
        Simulator simulator = new Simulator(new AdjacentStrategy());

        Cube next = cube;
        for (int i = 0; i < 6; i++) {
            next = simulator.simulate(cube);
            cube = next;
        }

        System.out.println(next);

        System.out.println(next.getCount());
    }
}
