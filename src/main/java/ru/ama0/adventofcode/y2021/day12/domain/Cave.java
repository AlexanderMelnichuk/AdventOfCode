package ru.ama0.adventofcode.y2021.day12.domain;

import lombok.Getter;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Cave {

    private final String name;
    private final boolean isSmall;
    private final Set<Cave> connections;

    public Cave(@Nonnull String name) {
        this.name = name;
        isSmall = name.charAt(0) >= 'a' && name.charAt(0) <= 'z';
        connections = new HashSet<>();
    }

    public void addConnection(Cave toCave) {
        connections.add(toCave);
    }

    @Override
    public String toString() {
        return name;
    }
}
