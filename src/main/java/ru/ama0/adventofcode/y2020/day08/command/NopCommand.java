package ru.ama0.adventofcode.y2020.day08.command;

import java.util.concurrent.atomic.AtomicInteger;

public class NopCommand extends Command {
    @Override
    public int exec(AtomicInteger accumulator) {
        return address + 1;
    }

    @Override
    public Command mutate() {
        Command command = new JmpCommand();
        command.address = address;
        command.value = value;
        return command;
    }
}
