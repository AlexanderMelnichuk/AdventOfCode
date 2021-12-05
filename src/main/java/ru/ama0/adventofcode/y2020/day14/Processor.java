package ru.ama0.adventofcode.y2020.day14;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Processor {
    private long maskSet = 0;
    private long maskClear = -1;

    private final Map<Integer, Long> memory = new HashMap<>();

    public void readMask(String mask) {
        long maskClearDecoded = Long.parseLong(mask.replace('X', '1'), 2);
        long maskSetDecoded = Long.parseLong(mask.replace('X', '0'), 2);
        // Make sure we don't have an exception here.
        maskClear = maskClearDecoded;
        maskSet = maskSetDecoded;
    }

    public void setValue(Integer address, long value) {
        memory.put(address, value & maskClear | maskSet);
    }

    public long getSum() {
        return memory.values().stream().reduce(Long::sum).orElse(0L);
    }
}
