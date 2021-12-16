package ru.ama0.adventofcode.y2021.template.application;

import org.junit.jupiter.api.BeforeEach;
import ru.ama0.adventofcode.y2021.day07.application.FuelConsumptionCalculator;
import ru.ama0.adventofcode.y2021.template.infrastructure.SomeRepositoryImpl;

import java.io.IOException;

class SomeInteractorTest {

    private SomeInteractor interactor;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new SomeRepositoryImpl();
        repository.init("/2021/inputXXtest.txt");

        interactor = new SomeInteractor(repository);
    }

}
