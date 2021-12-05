package ru.ama0.adventofcode.y2020.day25;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;

public class Day25a {
    private static final long DIVISOR = 20201227;

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day25.txt");
        long cardPk = Long.parseLong(lines.get(0));
        long doorPk = Long.parseLong(lines.get(1));

        long cardLoopSize = 0;
        long doorLoopSize = 0;
        long value = 1;
        long counter = 0;
        long subjectNumber = 7;
        while (cardLoopSize == 0 && doorLoopSize == 0) {
            counter++;
            value *= subjectNumber;
            value %= DIVISOR;
            if (value == cardPk) {
                cardLoopSize = counter;
            }
            if (value == doorPk) {
                doorLoopSize = counter;
            }
        }
        long loopSize;
        long pk;
        if (cardLoopSize > 0) {
            loopSize = cardLoopSize;
            pk = doorPk;
        } else {
            loopSize = doorLoopSize;
            pk = cardPk;
        }

        long encryptionKey = transform(pk, loopSize);
        System.out.println("Encryption key: " + encryptionKey);

    }

    private static long transform(long subjectNumber, long loopSize) {
        long value = 1;
        for (int i = 0; i < loopSize; i++) {
            value *= subjectNumber;
            value %= DIVISOR;
        }
        return value;
    }
}
