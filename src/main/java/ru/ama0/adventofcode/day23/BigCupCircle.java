package ru.ama0.adventofcode.day23;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BigCupCircle implements ICupCircle {
    public static final int MAX_CUP_VALUE = 1000000;

    @Getter
    private Integer cupsCount;
    @Setter
    @Getter
    private Cup currentCup;
    private Map<Integer, Cup> cupIndices;

    public BigCupCircle(String values) {
        Cup firstCup = new Cup(values.charAt(0) - '0');
        Cup lastCup = new Cup(values.charAt(values.length() - 1) - '0');
        int maxValue = Math.max(firstCup.getValue(), lastCup.getValue());
        Cup lastAddedCup = lastCup;
        Cup indexCup;
        for (int i = values.length() - 2; i > 0; i--) {
            indexCup = new Cup(values.charAt(i)- '0');
            indexCup.setNext(lastAddedCup);
            lastAddedCup = indexCup;
            if (maxValue < indexCup.getValue()) {
                maxValue = indexCup.getValue();
            }
        }
        firstCup.setNext(lastAddedCup);
        lastAddedCup = firstCup;
        for (int i = MAX_CUP_VALUE; i > maxValue; i--) {
            indexCup = new Cup(i);
            indexCup.setNext(lastAddedCup);
            lastAddedCup = indexCup;
        }
        lastCup.setNext(lastAddedCup);
        currentCup = firstCup;

        cupIndices = new HashMap<>(MAX_CUP_VALUE);
        indexCup = currentCup;
        do {
            cupIndices.put(indexCup.getValue(), indexCup);
            indexCup = indexCup.getNext();
        } while (indexCup != currentCup);
        cupsCount = MAX_CUP_VALUE;
    }

    @Override
    public Optional<Cup> findCup(int value) {
        return Optional.ofNullable(cupIndices.get(value));
    }

    @Override
    public void nextCurrent() {
        currentCup = currentCup.getNext();
    }

    @Override
    public String toString() {
        return toString(currentCup, 20);
    }

    @Override
    public String toString(int from) {
        return toString(findCup(from).get(), 20);
    }

    public String toString(Cup startingFrom, int count) {
        StringBuilder sb = new StringBuilder();
        Cup indexCup = startingFrom;
        for (int i = 0; i < count; i++) {
            sb.append(indexCup.getValue()).append(",");
            indexCup = indexCup.getNext();
        }
        return sb.toString();
    }
}
