package ru.ama0.adventofcode.y2020.day16;

import com.google.common.collect.Range;
import lombok.Getter;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public class DataHolder {
    private Map<String, Constraint> constraints;
    private List<Integer> myTicket;
    private List<List<Integer>> nearbyTickets;

    public static final Pattern CONSTRAINT_PATTERN = Pattern.compile("^([A-Za-z ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)$");

    public void loadFrom(String fileName) throws IOException {
        List<String> lines = Io.readLines(fileName);

        constraints = new HashMap<>();
        int counter = 0;
        for (String line : lines) {
            if (lines.get(counter).trim().isEmpty()) {
                break;
            }
            Matcher matcher = CONSTRAINT_PATTERN.matcher(line);
            if (matcher.find()) {
                Constraint constraint = new Constraint(matcher.group(1),
                        Range.closed(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))),
                        Range.closed(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5))));
                constraints.put(constraint.getName(), constraint);
            }
            counter++;
        }

        counter += 2;
        myTicket = Arrays.stream(lines.get(counter).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        nearbyTickets = new ArrayList<>();
        counter += 3;
        String line;
        while (counter < lines.size() && !(line = lines.get(counter++)).isEmpty()) {
            nearbyTickets.add(Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
    }
}
