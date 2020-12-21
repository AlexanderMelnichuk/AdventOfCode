package ru.ama0.adventofcode.day07;

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
