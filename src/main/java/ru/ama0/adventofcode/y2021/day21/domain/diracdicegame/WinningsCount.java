package ru.ama0.adventofcode.y2021.day21.domain.diracdicegame;

import lombok.Value;

@Value
public class WinningsCount {
    long p1Winnings;
    long p2Winnings;

    public WinningsCount reverse() {
        return new WinningsCount(p2Winnings, p1Winnings);
    }
}
