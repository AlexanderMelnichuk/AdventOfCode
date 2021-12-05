package ru.ama0.adventofcode.y2020.day08.command;

import java.util.concurrent.atomic.AtomicInteger;

public class JmpCommand extends Command {
    @Override
    public int exec(AtomicInteger accumulator) {
        return address + value;
    }

    @Override
    public Command mutate() {
        Command command = new NopCommand();
        command.address = address;
        command.value = value;
        return command;
    }
}
