package ru.ama0.adventofcode.y2021.day06.domain;

import java.util.Arrays;


public class FishCounter {

    private long[] fishCounts;

    public FishCounter(long[] fishCounts) {
        this.fishCounts = fishCounts;
    }

    public void liveOneDay() {
        var next = new long[9];
        next[8] = fishCounts[0];
        next[7] = fishCounts[8];
        next[6] = fishCounts[0] + fishCounts[7];
        next[5] = fishCounts[6];
        next[4] = fishCounts[5];
        next[3] = fishCounts[4];
        next[2] = fishCounts[3];
        next[1] = fishCounts[2];
        next[0] = fishCounts[1];

        fishCounts = next;
    }

    public long getTotalCount() {
        return Arrays.stream(fishCounts).sum();
    }

}
