package ru.ama0.adventofcode.day18.myparser.nodes;

import lombok.Data;

@Data
public class Node {
    private Long result;

    public Long calc() {
        return result;
    }

    private Node left;
    private Node right;

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
