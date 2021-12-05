package ru.ama0.adventofcode.y2020.day23;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "next")
public class Cup {
    private final int value;
    private Cup next;
}
