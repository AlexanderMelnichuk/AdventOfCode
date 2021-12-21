package ru.ama0.adventofcode.y2021.day17;

import ru.ama0.adventofcode.y2021.day17.application.ShotsCounter;
import ru.ama0.adventofcode.y2021.day17.domain.Target;

public class Main {

    public static void main(String[] args) {
        var shotsCounter = new ShotsCounter();
        var count = shotsCounter.execute(new Target(34, 67, -186, -215));
        System.out.println(count);
    }

}
