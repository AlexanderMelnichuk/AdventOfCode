package ru.ama0.adventofcode.y2020.day13;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
public class BusItinerary {
    private final long earliest;
    private final List<Bus> buses;

    public static BusItinerary from(String fileName) throws IOException {
        List<String> lines = Io.readLines(fileName);
        long earliest = Integer.parseInt(lines.get(0));

        List<Bus> buses = new ArrayList<>();
        int counter = 0;
        for (String number : lines.get(1).split(",")) {
            if (!"x".equals(number)) {
                buses.add(new Bus(Integer.parseInt(number), counter));
            }
            counter++;
        }
        return new BusItinerary(earliest, Collections.unmodifiableList(buses));
    }
}
