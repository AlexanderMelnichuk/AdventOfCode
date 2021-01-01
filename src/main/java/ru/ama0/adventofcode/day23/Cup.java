package ru.ama0.adventofcode.day23;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "next")
public class Cup {
    private final int value;
    private Cup next;
}
