package ru.ama0.adventofcode.day12;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day12 {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("(?<command>[NSEWLRF])(?<param>\\d+)");

    public static void main(String[] args) throws IOException {
        ShipByDirection shipByDirection = new ShipByDirection();
        ShipByWaypoint shipByWaypoint = new ShipByWaypoint();

        List<String> lines = Io.readLines("/day12.txt");
        for (String line : lines) {
            Matcher matcher = COMMAND_PATTERN.matcher(line);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Illegal data: " + line);
            }
            Character command = matcher.group("command").toCharArray()[0];
            Integer param = Integer.parseInt(matcher.group("param"));

            shipByDirection.move(command, param);
            shipByWaypoint.move(command, param);
        }

        System.out.printf("Ship by direction:%n" +
                        "x: %s, y: %s, angle: %s, Manhattan distance: %s%n",
                shipByDirection.getX(), shipByDirection.getY(), shipByDirection.getAngle(),
                shipByDirection.getManhattanDistance());
        System.out.printf("Ship by waypoint:%n" +
                        "x: %d, y: %d, waypoint x: %d, waypoint y: %d, Manhattan distance: %d%n",
                shipByWaypoint.getX(), shipByWaypoint.getY(), shipByWaypoint.getWaypointX(),
                shipByWaypoint.getWaypointY(), shipByWaypoint.getManhattanDistance());

    }
}
