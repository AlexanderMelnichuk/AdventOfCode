package ru.ama0.adventofcode.day12;

import lombok.Getter;
import lombok.ToString;

import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Consumer;

@SuppressWarnings("SuspiciousNameCombination")
@ToString(exclude = "moves")
@Getter
public class ShipByWaypoint {
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
    private int waypointX;
    private int waypointY;

    private final Map<Character, Consumer<Integer>> moves = Map.of(
            N, dist -> waypointY += dist,
            S, dist -> waypointY -= dist,
            E, dist -> waypointX += dist,
            W, dist -> waypointX -= dist,
            L, param -> {
                if (param == 180) {
                    waypointX = -1 * waypointX;
                    waypointY = -1 * waypointY;
                    return;
                }
                int tmpWaypointX = waypointX;
                int tmpWaypointY = waypointY;
                if (param == 90) {
                    waypointY = tmpWaypointX;
                    waypointX = -tmpWaypointY;
                } else if (param == 270) {
                    waypointY = -tmpWaypointX;
                    waypointX = tmpWaypointY;
                }
            },
            R, param -> {
                if (param == 180) {
                    waypointX = -1 * waypointX;
                    waypointY = -1 * waypointY;
                    return;
                }
                int tmpWaypointX = waypointX;
                int tmpWaypointY = waypointY;
                if (param == 90) {
                    waypointY = -tmpWaypointX;
                    waypointX = tmpWaypointY;
                } else if (param == 270) {
                    waypointY = tmpWaypointX;
                    waypointX = -tmpWaypointY;
                }
            },
            F, param -> {
                x += waypointX * param;
                y += waypointY * param;
            });

    public ShipByWaypoint() {
        x = 0;
        y = 0;
        waypointX = 10;
        waypointY = 1;
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
