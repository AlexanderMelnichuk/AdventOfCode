package ru.ama0.adventofcode.y2020.day08;

import ru.ama0.adventofcode.y2020.day08.command.Command;
import ru.ama0.adventofcode.y2020.day08.command.JmpCommand;
import ru.ama0.adventofcode.y2020.day08.command.NopCommand;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Day08 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Command> mem = new TreeMap<>();
        List<String> lines = Io.readLines("/day08.txt");
        for (int address = 0; address < lines.size(); address++) {
            mem.put(address, Command.of(address, lines.get(address)));
        }

        AtomicInteger accumulator = new AtomicInteger();
        int cp = 0;
        Set<Integer> passed = new HashSet<>();
        while (!passed.contains(cp)) {
            passed.add(cp);
            cp = mem.get(cp).exec(accumulator);
        }
        System.out.println(accumulator.get());

        // Part 2
        Set<Integer> mutableCommandsAddresses = new HashSet<>();
        for (int address = 0; address < mem.size(); address++) {
            Command command = mem.get(address);
            if (command instanceof JmpCommand || command instanceof NopCommand) {
                mutableCommandsAddresses.add(address);
            }
        }
        System.out.println("Mutable commands count: " + mutableCommandsAddresses.size());

        int exitPosition = mem.size();
        int mutatedCommands = 0;
        for (Integer addressToMutate : mutableCommandsAddresses) {
            mutatedCommands++;
            accumulator.set(0);
            cp = 0;
            passed.clear();
            while (!passed.contains(cp)) {
                passed.add(cp);
                Command command = mem.get(cp);
                if (cp == addressToMutate) {
                    command = command.mutate();
                }
                cp = command.exec(accumulator);
                if (cp == exitPosition) {
                    System.out.println(accumulator.get());
                    System.out.println("Mutated commands: " + mutatedCommands);
                    return;
                }
            }
        }


    }
}
