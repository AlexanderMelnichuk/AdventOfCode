package ru.ama0.adventofcode.y2021.day21.domain.dicegame;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private int score;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
        resetScore();
    }

    public void increaseScore(int value) {
        score += value;
    }

    void resetScore() {
        score = 0;
    }

    void setPosition(int position) {
        this.position = position;
    }

}
