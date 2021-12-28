package ru.ama0.adventofcode.y2021.day07.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class Crabs {

    @Getter
    private final Collection<Integer> positions;

    public long calcRequiredFuel(int position, BiFunction<Integer, Integer, Long> fuelFunction) {
        return positions.stream()
                .map(x -> fuelFunction.apply(position, x))
                .reduce(Long::sum)
                .orElse(0L);
    }

    public int min() {
        return positions.stream().min(Integer::compare).orElseThrow(() -> new IllegalStateException("no elements"));
    }

    public int max() {
        return positions.stream().max(Integer::compare).orElseThrow(() -> new IllegalStateException("no elements"));
    }

}
