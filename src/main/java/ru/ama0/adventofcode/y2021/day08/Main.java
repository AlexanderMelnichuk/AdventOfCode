package ru.ama0.adventofcode.y2021.day08;

import ru.ama0.adventofcode.y2021.day08.application.DigitSummarizer;
import ru.ama0.adventofcode.y2021.day08.application.Digits1478Counter;
import ru.ama0.adventofcode.y2021.day08.infrastructure.DisplayDigitsRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var repository = new DisplayDigitsRepositoryImpl();
        repository.init("/2021/input08.txt");
        var digits1478Counter = new Digits1478Counter(repository);

        var digits1478Count = digits1478Counter.execute();
        System.out.println(digits1478Count);

        var digitSummarizer = new DigitSummarizer(repository);
        System.out.println(digitSummarizer.execute());
    }
}
