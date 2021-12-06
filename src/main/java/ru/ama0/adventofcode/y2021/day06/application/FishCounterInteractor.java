package ru.ama0.adventofcode.y2021.day06.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day06.application.interfaces.LanternFishRepository;
import ru.ama0.adventofcode.y2021.day06.domain.FishCounter;

@RequiredArgsConstructor
public class FishCounterInteractor {

    private final LanternFishRepository repository;

    public long execute(int days) {
        var counts = repository.retrieveCounts();
        var fishCounter = new FishCounter(counts);
        for (int i = 0; i < days; i++) {
            fishCounter.liveOneDay();
        }
        return fishCounter.getTotalCount();
    }

}
