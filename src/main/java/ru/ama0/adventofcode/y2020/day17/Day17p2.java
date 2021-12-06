package ru.ama0.adventofcode.y2020.day17;

import ru.ama0.adventofcode.y2020.day17.cube.Cube;
import ru.ama0.adventofcode.y2020.day17.cube.CubeReader;
import ru.ama0.adventofcode.y2020.day17.cube.HCube;
import ru.ama0.adventofcode.y2020.day17.cube.HSimulator;
import ru.ama0.adventofcode.y2020.day17.cube.HStrategy;

import java.io.IOException;

public class Day17p2 {
    public static void main(String[] args) throws IOException {
        Cube cube = CubeReader.fromFile("/2020/day17.txt");

        HSimulator simulator = new HSimulator(new HStrategy());

        HCube hCube = new HCube(cube);
        HCube next = new HCube(cube);
        for (int i = 0; i < 6; i++) {
            next = simulator.simulate(hCube);
            hCube = next;
        }

        System.out.println(next.getCount());

    }

}
