package ru.ama0.adventofcode.y2021.day20.application.ports;

public interface ImageRepository {
    String getAlgorithm();

    ru.ama0.adventofcode.y2021.day20.domain.Image getImage();
}
