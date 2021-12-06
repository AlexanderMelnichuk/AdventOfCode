package ru.ama0.adventofcode.y2021.day06;

import ru.ama0.adventofcode.y2021.day06.application.FishCounterInteractor;
import ru.ama0.adventofcode.y2021.day06.infrastructure.LanternFishRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var fishRepository = new LanternFishRepositoryImpl();
        fishRepository.init("/2021/input06.txt");
        var fishCounterInteractor = new FishCounterInteractor(fishRepository);
        var total80 = fishCounterInteractor.execute(80);
        var total256 = fishCounterInteractor.execute(256);
        System.out.println(total80);
        System.out.println(total256);
    }

}
