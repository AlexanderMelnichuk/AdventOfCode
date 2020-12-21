package ru.ama0.adventofcode.day08.command;

import lombok.val;

import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public abstract class Command {
    protected int address;
    protected int value;

    private static final Pattern COMMAND_PATTERN = Pattern.compile("^(?<op>(acc|jmp|nop)) (?<value>[+-]\\d+)$");

    public static Command of(int address, String str) {
        val matcher = COMMAND_PATTERN.matcher(str);
        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    MessageFormat.format("String {0} does not contain a valid command", str));
        }

        Command command;
        String type = matcher.group("op");
        switch (type) {
            case "nop":
                command = new NopCommand();
                break;
            case "jmp":
                command = new JmpCommand();
                break;
            case "acc":
                command = new AccCommand();
                break;
            default:
                throw new IllegalArgumentException("Unknown command");
        }
        command.value = Integer.parseInt(matcher.group("value"));
        command.address = address;
        return command;
    }

    /**
     * Runs the command
     * @param accumulator - accumulator
     * @return next address
     */
    public abstract int exec(AtomicInteger accumulator);

    /**
     * Mutates the command to another command
     * @return mutated command
     */
    public abstract Command mutate();
}
