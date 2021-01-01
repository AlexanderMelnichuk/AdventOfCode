package ru.ama0.adventofcode.day19;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Node {
    private final int id;
    private char value;
    private List<List<Integer>> options;

    public Node(int id, char value) {
        this.id = id;
        this.value = value;
    }

    public Node(int id, List<List<Integer>> options) {
        this.id = id;
        this.options = options;
    }

    public boolean isValueNode() {
        return value != 0;
    }

    @Override
    public String toString() {
        return id + ":" + ((value == 0) ? options : value);
    }
}
