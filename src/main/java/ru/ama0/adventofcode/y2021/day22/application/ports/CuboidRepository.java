package ru.ama0.adventofcode.y2021.day22.application.ports;

import ru.ama0.adventofcode.y2021.day22.domain.Cuboid;

import java.util.List;

public interface CuboidRepository {

    List<Cuboid> getCuboids();

}
