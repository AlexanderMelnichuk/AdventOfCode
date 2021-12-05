package ru.ama0.adventofcode.y2020.day23;

import java.util.Optional;

public interface ICupCircle {
    Integer getCupsCount();

    Optional<Cup> findCup(int value);

    void nextCurrent();

    ICupCircle setCurrentCup(Cup currentCup);

    Cup getCurrentCup();

    String toString();

    String toString(int from);
}
