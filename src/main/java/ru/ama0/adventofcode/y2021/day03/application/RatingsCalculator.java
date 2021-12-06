package ru.ama0.adventofcode.y2021.day03.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day03.application.interfaces.InputDataRepository;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RatingsCalculator {

    private final InputDataRepository repository;

    public int calculateOxygenGeneratorRating() {
        return calculateRating(this::findMostCommonValue);
    }

    public int calculateCo2ScrubberRating() {
        return calculateRating(this::findLeastCommonValue);
    }

    private int calculateRating(BiFunction<List<Integer>, Integer, Integer> valueFinder) {
        var numbers = repository.retrieveNumbers();
        var digitNumber = repository.getDigitCount() - 1;

        int value;
        while (numbers.size() > 1 && digitNumber >= 0) {
            value = valueFinder.apply(numbers, digitNumber);
            numbers = filterByValue(numbers, digitNumber, value);
            digitNumber--;
        }
        return numbers.get(0);

    }

    private List<Integer> filterByValue(List<Integer> numbers, int digitNumber, int value) {
        int mask = 1 << digitNumber;
        int valueMask = value << digitNumber;
        return numbers.stream()
                .filter(number -> (number & mask) == valueMask)
                .collect(Collectors.toList());
    }

    private int findMostCommonValue(List<Integer> numbers, Integer digitNumber) {
        int mask = 1 << digitNumber;
        var zeroCount = numbers.stream()
                .map(number -> number & mask)
                .filter(number -> number == 0)
                .count();
        return (zeroCount > numbers.size() / 2)
                ? 0
                : 1;
    }

    private int findLeastCommonValue(List<Integer> numbers, Integer digitNumber) {
        return 1 - findMostCommonValue(numbers, digitNumber);
    }

}
