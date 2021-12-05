package ru.ama0.adventofcode.y2020.day07;

import lombok.Data;

@Data
public class BagCount {
    private Bag bag;
    private int count;

    public BagCount(Bag bag, int count) {
        this.bag = bag;
        this.count = count;
    }
}
