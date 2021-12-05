package ru.ama0.adventofcode.y2020.day19;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.ama0.adventofcode.util.Io;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

@Getter
@RequiredArgsConstructor
@ToString
public class DataHolder {
    private final Map<Integer, Node> nodes;

    private final List<String> messages;

    private static final Pattern NODE_PATTERN = Pattern.compile("^(\\d+): ([0-9 ]+)( \\| ([0-9 ]+))?$");
    private static final Pattern LEAF_PATTERN = Pattern.compile("^(\\d+): \"([ab])\"$");

    public static DataHolder loadFrom(String fileName) throws IOException {
        List<String> lines = Io.readLines(fileName);

        Map<Integer, Node> nodes = new HashMap<>();

        int counter;
        String line;
        for (counter = 0; !(line = lines.get(counter).trim()).isEmpty(); counter++) {
            Matcher matcher = NODE_PATTERN.matcher(line);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                List<Integer> option1 = Arrays.stream(matcher.group(2).split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                List<List<Integer>> options = new ArrayList<>();
                options.add(option1);
                if (matcher.groupCount() > 3 && matcher.group(4) != null) {
                    options.add(Arrays.stream(matcher.group(4).split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                }
                Node node = new Node(id, options);
                nodes.put(id, node);
            } else if ((matcher = LEAF_PATTERN.matcher(line)).find()) {
                int id = Integer.parseInt(matcher.group(1));
                char value = matcher.group(2).charAt(0);
                Node node = new Node(id, value);
                nodes.put(id, node);
            } else {
                throw new IllegalArgumentException("Invalid line: " + line);
            }
        }

        List<String> messages = lines.subList(counter + 1, lines.size()).stream()
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toList());

        return new DataHolder(nodes, messages);
    }

    public boolean complies(@Nonnull String message) {
        if (message.isEmpty()) {
            return false;
        }

        Node rootNode = nodes.get(0);
        int position = 0;
        Set<Integer> nextPositions = traverse(message, position, rootNode);
        return nextPositions.contains(message.length());
    }

    public int complyingCount() {
        return (int) messages.stream()
                .filter(this::complies)
                .count();
    }

    public Set<Integer> traverse(String message, int position, Node node) {
        if (position >= message.length()) {
            return emptySet();
        }
        if (node.isValueNode()) {
            if (message.charAt(position) == node.getValue()) {
                return Set.of(position + 1);
            }
            return emptySet();
        }
        Set<Integer> resultSet = new HashSet<>();
        for (List<Integer> subNodesOption : node.getOptions()) {
            // Checking the option
            Set<Integer> positionsToCheck = new HashSet<>();
            positionsToCheck.add(position);
            Set<Integer> positionsAfterCheck = new HashSet<>();
            for (Integer subNode : subNodesOption) {
                positionsAfterCheck = new HashSet<>();
                for (Integer positionToCheck : positionsToCheck) {
                    positionsAfterCheck.addAll(traverse(message, positionToCheck, nodes.get(subNode)));
                }
                if (positionsAfterCheck.isEmpty()) {
                    break; // Option is not applicable, discard it
                }
                positionsToCheck = positionsAfterCheck;
            }
            // After the last subnode we have option check result in positionsAfterCheck set.
            resultSet.addAll(positionsAfterCheck);
        }
        return resultSet;
    }

}
