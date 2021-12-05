package ru.ama0.adventofcode.y2020;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;

public class Day05 {

    public static final int SEATS = 1024;

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day05.txt");
        BitSet bitSet = new BitSet(SEATS);
        bitSet.clear();
        int max = 0;
        int min = SEATS;
        for (String line : lines) {
            int seat = Integer.valueOf(line.replace('F', '0')
                    .replace('B', '1')
                    .replace('L', '0')
                    .replace('R', '1'), 2);
            if (seat > max) {
                max = seat;
            }
            if (seat < min) {
                min = seat;
            }
            bitSet.set(seat);
        }
        bitSet.flip(min, max);
        System.out.println("max = " + max);
        System.out.println("missing = " + bitSet.nextSetBit(min));
    }
}
