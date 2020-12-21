package ru.ama0.adventofcode.day17.cube;

import lombok.experimental.UtilityClass;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;

@UtilityClass
public class CubeReader {
    public static Cube fromFile(String fileName) throws IOException {
        List<String> lines = Io.readLines(fileName);
        int sizeX = lines.size();
        int sizeY = lines.get(0).length();
        int sizeZ = 1;
        boolean[][][] state = new boolean[sizeX][sizeY][sizeZ];
        String line;
        for (int x = 0; x < sizeX; x++) {
            line = lines.get(x);
            for (int y = 0; y < sizeY; y++) {
                state[x][y][0] = (line.charAt(y) == '#');
            }
        }
        return new Cube(state);
    }
}
