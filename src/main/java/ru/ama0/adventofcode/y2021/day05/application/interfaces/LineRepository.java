package ru.ama0.adventofcode.y2021.day05.application.interfaces;

import ru.ama0.adventofcode.y2021.day05.domain.Line;

import java.io.IOException;
import java.util.List;

public interface LineRepository {

    void init(String fileName) throws IOException;

    List<Line> getAllLines();

}
