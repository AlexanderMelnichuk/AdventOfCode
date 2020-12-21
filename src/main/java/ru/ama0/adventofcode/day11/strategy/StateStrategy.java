package ru.ama0.adventofcode.day11.strategy;

@FunctionalInterface
public interface StateStrategy {

    Character getNextState(char[][] state, Integer b, Integer c);
}