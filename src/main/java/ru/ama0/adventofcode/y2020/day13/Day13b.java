package ru.ama0.adventofcode.y2020.day13;

import lombok.val;
import ru.ama0.adventofcode.y2020.day13.math.Modular;
import ru.ama0.adventofcode.y2020.day13.math.ModularSystem;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day13b {
    public static void main(String[] args) throws IOException {
        BusItinerary busItinerary = BusItinerary.from("/day13.txt");
        List<Bus> buses = busItinerary.getBuses();
        System.out.println(busItinerary);
        System.out.println();

        long firstBusNumber = buses.get(0).getNumber();
        List<Modular> modulars = new ArrayList<>();
        for (int i = 1; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            modulars.add(Modular.of(firstBusNumber, -bus.getShift(), bus.getNumber()));
        }
        val modularSystem = ModularSystem.of(modulars);
        System.out.println(modularSystem.getX().multiply(BigInteger.valueOf(firstBusNumber)));

    }
}
