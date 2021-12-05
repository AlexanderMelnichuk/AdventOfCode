package ru.ama0.adventofcode.y2020.day08.command;

import java.util.concurrent.atomic.AtomicInteger;

public class AccCommand extends Command {
    @Override
    public int exec(AtomicInteger accumulator) {
        accumulator.addAndGet(value);
        return address + 1;
    }

    @Override
    public Command mutate() {
        return this;
    }
}
