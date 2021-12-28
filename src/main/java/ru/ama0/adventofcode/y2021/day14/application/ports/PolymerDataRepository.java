package ru.ama0.adventofcode.y2021.day14.application.ports;

import ru.ama0.adventofcode.y2021.day14.domain.PairInsertionRule;

import java.util.Map;

public interface PolymerDataRepository {

    String getTemplate();
    Map<String, PairInsertionRule> getPairInsertionRules();

}
