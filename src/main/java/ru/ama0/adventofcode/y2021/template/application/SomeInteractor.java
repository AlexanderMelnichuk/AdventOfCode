package ru.ama0.adventofcode.y2021.template.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.template.application.ports.SomeRepository;

@RequiredArgsConstructor
public class SomeInteractor {

    private final SomeRepository repository;

    public long execute() {
        return 0L;
    }


}
