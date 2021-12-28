package ru.ama0.adventofcode.y2021.day08.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day08.application.ports.DisplayDigitsRepository;

import java.util.Collection;

@RequiredArgsConstructor
public class Digits1478Counter {

    private final DisplayDigitsRepository repository;

    public long execute() {
        var requests = repository.getAll();
        return requests.stream()
                .map(DigitsRequest::getRequiredDigits)
                .flatMap(Collection::stream)
                .map(String::length)
                .filter(length -> length == 2 || length == 3 || length == 4 || length == 7)
                .count();
    }

}
