package ru.ama0.adventofcode.y2021.day19.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day19.application.ports.ScannerBeaconsRepository;
import ru.ama0.adventofcode.y2021.day19.domain.Scanner;
import ru.ama0.adventofcode.y2021.day19.domain.Voxel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerBeaconsRepositoryImpl implements ScannerBeaconsRepository {

    private static final Pattern HEADER_LINE = Pattern.compile("--- scanner (\\d+) ---");

    private List<Scanner> scanners = new ArrayList<>();

    public void init(String filename) throws IOException {
        var lines = Io.readLines(filename);
        var newScanners = new ArrayList<Scanner>();
        String line;
        Matcher matcher;
        var linesIterator = lines.iterator();
        do {
            do {
                line = linesIterator.next();
                matcher = HEADER_LINE.matcher(line);
            } while (!matcher.matches());
            var scannerNumber = matcher.group(1);
            var beacons = new ArrayList<Voxel>();
            while (linesIterator.hasNext() && !(line = linesIterator.next()).isEmpty()) {
                var coords = line.split(",");
                beacons.add(new Voxel(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]),
                        Integer.parseInt(coords[2])));
            }
            newScanners.add(new Scanner(scannerNumber, beacons));
        } while (linesIterator.hasNext());
        scanners = newScanners;
    }

    @Override
    public List<Scanner> getScanners() {
        return new ArrayList<>(scanners);
    }

}
