package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.Value;

import java.util.function.UnaryOperator;

@Value
public class Rotor {

    String name;
    UnaryOperator<Voxel> operator;

}
