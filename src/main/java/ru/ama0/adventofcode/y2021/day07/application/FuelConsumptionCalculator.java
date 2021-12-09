package ru.ama0.adventofcode.y2021.day07.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day07.application.ports.CrabPositionsRepository;
import ru.ama0.adventofcode.y2021.day07.domain.Crabs;

import javax.annotation.Nonnull;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class FuelConsumptionCalculator {

    private final CrabPositionsRepository repository;

    public long execute(@Nonnull FuelConsumptionType fuelConsumptionType) {
        var crabs = new Crabs(repository.getAll());

        BiFunction<Integer, Integer, Long> function;
        if (fuelConsumptionType == FuelConsumptionType.LINEAR) {
            function = this::linearConsumption;
        } else {
            function = this::progressiveConsumption;
        }

        long minConsumption = Long.MAX_VALUE;
        for (int position = crabs.min(); position <= crabs.max(); position++) {
            var consumption = crabs.calcRequiredFuel(position, function);
            if (consumption < minConsumption) {
                minConsumption = consumption;
            }
        }

        return minConsumption;
    }

    long linearConsumption(int x, int position) {
        return Math.abs(position - x);
    }

    long progressiveConsumption(int x, int position) {
        var n = (long) Math.abs(position - x);
        return n * (n + 1) / 2;
    }

}
