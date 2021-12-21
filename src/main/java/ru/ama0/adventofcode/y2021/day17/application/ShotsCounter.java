package ru.ama0.adventofcode.y2021.day17.application;

import ru.ama0.adventofcode.y2021.day17.domain.Shooter;
import ru.ama0.adventofcode.y2021.day17.domain.Target;

public class ShotsCounter {

    public int execute(Target target) {
        var shooter = new Shooter(target);
        var minX = (int) Math.floor(Math.sqrt(1.0 + 8 * target.getXFrom()) - 1) / 2;
        var minY = target.getYTo();
        var maxX = target.getXTo();
        var maxY = -target.getYTo() - 1;
        var counter = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (shooter.shoot(x, y)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
