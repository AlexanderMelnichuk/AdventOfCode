package ru.ama0.adventofcode.y2021.day08.application.ports;

import ru.ama0.adventofcode.y2021.day08.application.DigitsRequest;

import java.util.List;

public interface DisplayDigitsRepository {

    List<DigitsRequest> getAll();

}
