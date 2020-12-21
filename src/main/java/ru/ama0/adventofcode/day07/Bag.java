package ru.ama0.adventofcode.day07;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(of = {"name", "contains"})
public class Bag {
    @EqualsAndHashCode.Include
    private String name;
    private Set<BagCount> contains = new HashSet<>();
    private Set<Bag> canBeIn = new HashSet<>();

    public Bag(String name) {
        this.name = name;
    }


}
