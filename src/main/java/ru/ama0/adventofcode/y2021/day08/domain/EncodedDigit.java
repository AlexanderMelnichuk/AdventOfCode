package ru.ama0.adventofcode.y2021.day08.domain;

import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class EncodedDigit {

    String id;
    Set<Character> characters;

    public EncodedDigit(String encodedCharacters) {
        this.id = encodedCharacters;
        characters = encodedCharacters.chars()
                .collect(HashSet::new,
                        (set, charInt) -> set.add((char) charInt),
                        HashSet::addAll);
    }

}
