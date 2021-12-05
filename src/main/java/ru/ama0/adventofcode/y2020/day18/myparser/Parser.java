package ru.ama0.adventofcode.y2020.day18.myparser;

import ru.ama0.adventofcode.y2020.day18.myparser.nodes.DivNode;
import ru.ama0.adventofcode.y2020.day18.myparser.nodes.MinusNode;
import ru.ama0.adventofcode.y2020.day18.myparser.nodes.MulNode;
import ru.ama0.adventofcode.y2020.day18.myparser.nodes.Node;
import ru.ama0.adventofcode.y2020.day18.myparser.nodes.PlusNode;

public class Parser {

    public static final char MUL = '*';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char DIV = '/';
    public static final char PAR_OPEN = '(';

    public Node parse(String s) {
        int index = 0;
        Node nextNode;
        Node previousNode = null;
        while (index < s.length()) {
            char current = s.charAt(index);
            if (current == ' ') {
                index++;
                continue;
            }
            if (current == MUL || current == PLUS || current == MINUS || current == DIV) {
                // Operation
                if (current == MUL) {
                    nextNode = new MulNode();
                } else if (current == PLUS) {
                    nextNode = new PlusNode();
                } else if (current == MINUS) {
                    nextNode = new MinusNode();
                } else {
                    nextNode = new DivNode();
                }

                nextNode.setLeft(previousNode);
                previousNode = nextNode;
            } else {
                // Value
                if (current == PAR_OPEN) {
                    int closingIndex = findClosing(index, s);
                    nextNode = parse(s.substring(index + 1, closingIndex));
                    index = closingIndex;
                } else {
                    nextNode = new Node().setResult(Long.parseLong(String.valueOf(current)));
                }
                if (previousNode == null) {
                    previousNode = nextNode;
                } else {
                    previousNode.setRight(nextNode);
                }
            }
            index++;
        }
        return previousNode;
    }

    private int findClosing(int startingPosition, String stringToParse) {
        int open = 1;
        int index = startingPosition + 1;
        while (index < stringToParse.length() && open > 0) {
            char currentChar = stringToParse.charAt(index);
            if (currentChar == '(') {
                open++;
            } else if (currentChar == ')') {
                open--;
            }
            index++;
        }
        if (open == 0) {
            return --index;
        } else {
            throw new IllegalArgumentException("Opening and closing parentheses don't match");
        }
    }
}
