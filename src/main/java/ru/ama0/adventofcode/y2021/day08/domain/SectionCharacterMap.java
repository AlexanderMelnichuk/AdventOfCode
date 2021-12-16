package ru.ama0.adventofcode.y2021.day08.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SectionCharacterMap {

    private final Map<Integer, Character> sectionToCharacterMap = new HashMap<>(7);
    private final Map<Character, Integer> characterToSectionMap = new HashMap<>(7);

    public void match(Character character, Integer section) {
        sectionToCharacterMap.put(section, character);
        characterToSectionMap.put(character, section);
    }

}
