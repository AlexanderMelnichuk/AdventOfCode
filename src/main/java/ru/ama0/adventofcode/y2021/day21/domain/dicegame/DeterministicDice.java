package ru.ama0.adventofcode.y2021.day21.domain.dicegame;

import lombok.Getter;

public class DeterministicDice implements Dice {

    private static final int SIDES = 100;

    @Getter
    private int value;

    @Override
    public int roll() {
        ++value;
        if (value > SIDES) {
            value = 1;
        }
        return value;
    }
}
