package ru.ama0.adventofcode.y2021.day12.application.ports;

import ru.ama0.adventofcode.y2021.day12.domain.Cave;

import java.util.Map;

public interface CaveRepository {

    Map<String, Cave> getAll();

}
