package ru.ama0.adventofcode.day23;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class SmallCupCircle implements ICupCircle {
    @Getter
    private Integer cupsCount;
    @Setter
    @Getter
    private Cup currentCup;

    public SmallCupCircle(String values) {
        Cup firstCup = new Cup(values.charAt(0) - '0');
        Cup lastAddedCup = firstCup;
        Cup indexCup;
        for (int i = values.length() - 1; i > 0; i--) {
            indexCup = new Cup(values.charAt(i)- '0');
            indexCup.setNext(lastAddedCup);
            lastAddedCup = indexCup;
        }
        firstCup.setNext(lastAddedCup);
        currentCup = firstCup;
        cupsCount = values.length();
    }

    @Override
    public Optional<Cup> findCup(int value) {
        return findCup(value, currentCup);
    }

    public Optional<Cup> findCup(int value, Cup startingCup) {
        Cup indexCup = startingCup;
        do {
            if (indexCup.getValue() == value) {
                return Optional.of(indexCup);
            }
            indexCup = indexCup.getNext();
        } while (indexCup != currentCup);
        return Optional.empty();
    }

    @Override
    public void nextCurrent() {
        currentCup = currentCup.getNext();
    }

    @Override
    public String toString() {
        return toString(currentCup);
    }

    @Override
    public String toString(int from) {
        return toString(findCup(from).get());
    }

    public String toString(Cup startingFrom) {
        StringBuilder sb = new StringBuilder();
        Cup indexCup = startingFrom;
        do {
            sb.append(indexCup.getValue());
            indexCup = indexCup.getNext();
        } while (indexCup != startingFrom);
        return sb.toString();
    }
}
