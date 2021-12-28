package ru.ama0.adventofcode.y2021.day14.domain;

import lombok.Value;

@Value
public class PairInsertionRule {

    String pair;
    Character element;

    public String getLeftPair() {
        return new String(new char[] {pair.charAt(0), element});
    }

    public String getRightPair() {
        return new String(new char[] {element, pair.charAt(1)});
    }

}
