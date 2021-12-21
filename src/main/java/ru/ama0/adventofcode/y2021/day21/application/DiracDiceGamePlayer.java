package ru.ama0.adventofcode.y2021.day21.application;

import ru.ama0.adventofcode.y2021.day21.domain.diracdicegame.Calculator;

public class DiracDiceGamePlayer {

    public long execute() {
        var calculator = new Calculator();
        calculator.init();
        var result = calculator.fill(0, 0, 8, 10);
        return Math.max(result.getP1Winnings(), result.getP2Winnings());
    }
}
