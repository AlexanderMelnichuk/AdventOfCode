package ru.ama0.adventofcode.y2020.day12;

import lombok.Getter;
import lombok.ToString;

import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Consumer;

@ToString(exclude = "moves")
@Getter
public class ShipByDirection {
    public static final Character N = 'N';
    public static final Character S = 'S';
    public static final Character E = 'E';
    public static final Character W = 'W';
    public static final Character L = 'L';
    public static final Character R = 'R';
    public static final Character F = 'F';

    private static final Map<Integer, Character> DIRECTIONS = Map.of(0, E, 90, N, 180, W, 270, S);

    private int x;
    private int y;
    private int angle;

    private final Map<Character, Consumer<Integer>> moves = Map.of(
            N, dist -> y += dist,
            S, dist -> y -= dist,
            E, dist -> x += dist,
            W, dist -> x -= dist,
            L, param -> angle = (angle + param) % 360,
            R, param -> angle = (angle + 360 - param) % 360,
            F, param -> move(DIRECTIONS.get(angle), param));

    public ShipByDirection() {
        x = 0;
        y = 0;
        angle = 0;
    }

    public void move(Character command, Integer param) {
        if (!moves.containsKey(command)) {
            throw new IllegalArgumentException(MessageFormat.format("Illegal command: {0}", command));
        }
        moves.get(command).accept(param);
    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }
}
