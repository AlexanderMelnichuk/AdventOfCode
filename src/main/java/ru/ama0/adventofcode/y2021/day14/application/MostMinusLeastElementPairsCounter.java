package ru.ama0.adventofcode.y2021.day14.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day14.application.ports.PolymerDataRepository;
import ru.ama0.adventofcode.y2021.day14.domain.PolymerPairs;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MostMinusLeastElementPairsCounter {

    private final PolymerDataRepository repository;

    public long execute(int steps) {
        var rules = repository.getPairInsertionRules();
        var template = repository.getTemplate();
        var polymerPairs = new PolymerPairs(template);
        for (int counter = 0; counter < steps; counter++) {
            polymerPairs.applyRules(rules.values());
        }

        var elementCounted = polymerPairs.getPairs().entrySet()
                .stream()
                .flatMap(entry -> ((entry.getKey().charAt(0) == entry.getKey().charAt(1))
                        ? Map.of(entry.getKey().charAt(0), entry.getValue() * 2)
                        : Map.of(entry.getKey().charAt(0), entry.getValue(),
                                entry.getKey().charAt(1), entry.getValue()))
                        .entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)));
        var firstElement = template.charAt(0);
        var lastElement = template.charAt(template.length() - 1);
        elementCounted.put(firstElement, elementCounted.get(firstElement) + 1);
        elementCounted.put(lastElement, elementCounted.get(lastElement) + 1);

        var elementCounts = elementCounted.values().stream().sorted().collect(Collectors.toList());

        return (elementCounts.get(elementCounts.size() - 1) - elementCounts.get(0)) / 2;
    }
}
