package ru.ama0.adventofcode.y2021.day19.application.ports;

import ru.ama0.adventofcode.y2021.day19.domain.Scanner;

import java.util.List;

public interface ScannerBeaconsRepository {

    List<Scanner> getScanners();

}
