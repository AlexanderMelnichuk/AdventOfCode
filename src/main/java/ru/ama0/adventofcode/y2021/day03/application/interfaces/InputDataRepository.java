package ru.ama0.adventofcode.y2021.day03.application.interfaces;

import java.io.IOException;
import java.util.List;

public interface InputDataRepository {

    void init() throws IOException;

    List<Integer> retrieveNumbers();

    Integer getDigitCount();

}
