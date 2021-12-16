package ru.ama0.adventofcode.y2021.template;

import ru.ama0.adventofcode.y2021.template.infrastructure.SomeRepositoryImpl;
import ru.ama0.adventofcode.y2021.template.application.SomeInteractor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new SomeRepositoryImpl();
        repository.init("/2021/input07.txt");
        var interactor = new SomeInteractor(repository);

        var result = interactor.execute();

        System.out.println(result);
    }
}
