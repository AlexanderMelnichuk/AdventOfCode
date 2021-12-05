package ru.ama0.adventofcode.y2020.day24;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day24 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day24.txt");
        Set<Tile> flipped = new HashSet<>();
        int hit = 0;
        int miss = 0;
        for (String line : lines) {
            line = line.replaceAll("(?<=([^ns]|^))e", "ee").replaceAll("(?<=([^ns]|^))w", "ww");
            long e = line.chars().filter(c -> c == 'e').count();
            long w = line.chars().filter(c -> c == 'w').count();
            long s = line.chars().filter(c -> c == 's').count();
            long n = line.chars().filter(c -> c == 'n').count();
            Tile coords  = new Tile((int)(e - w), (int)(n - s));
            if (flipped.contains(coords)) {
                flipped.remove(coords);
            } else {
                flipped.add(coords);
            }
        }
        System.out.printf("Hit: %d, miss: %d%n", hit, miss);
        System.out.println(flipped.size());
        
        Floor floor = new Floor(flipped);
        for (int i = 0; i < 100; i++) {
            floor.setTiles(floor.nextTiles());
        }
        System.out.println("Count: " + floor.getTiles().size());
    }


}
