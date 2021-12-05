package ru.ama0.adventofcode.y2020.day17;

import ru.ama0.adventofcode.y2020.day17.cube.AdjacentStrategy;
import ru.ama0.adventofcode.y2020.day17.cube.Cube;
import ru.ama0.adventofcode.y2020.day17.cube.CubeReader;
import ru.ama0.adventofcode.y2020.day17.cube.Simulator;

import java.io.IOException;

public class Day17 {
    public static void main(String[] args) throws IOException {
        Cube cube = CubeReader.fromFile("/day17.txt");

        Simulator simulator = new Simulator(new AdjacentStrategy());

        Cube next = cube;
        for (int i = 0; i < 6; i++) {
            next = simulator.simulate(cube);
            cube = next;
        }

        System.out.println(next.getCount());

    }

}
