package ru.ama0.adventofcode.y2021.day08.domain;

import lombok.Value;

import java.util.Set;

@Value
public class Digit {

    int number;
    Set<Integer> sections;

}
