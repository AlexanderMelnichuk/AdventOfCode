package ru.ama0.adventofcode.y2021.day10.domain;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class Constants {

    public static final Map<Character, Long> ERROR_SCORE = Map.of(
            ')', 3L,
            ']', 57L,
            '}', 1197L,
            '>', 25137L);

    public static final Map<Character, Long> COMPLETION_SCORE = Map.of(
            '(', 1L,
            '[', 2L,
            '{', 3L,
            '<', 4L);

    public static final Map<Character, Character> BRACKET_PAIRS = Map.of(
            ')', '(',
            ']', '[',
            '}', '{',
            '>', '<');

}
