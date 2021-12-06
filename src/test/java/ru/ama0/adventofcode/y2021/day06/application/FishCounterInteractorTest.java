package ru.ama0.adventofcode.y2021.day06.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day06.infrastructure.LanternFishRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class FishCounterInteractorTest {

    private FishCounterInteractor fishCounterInteractor;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new LanternFishRepositoryImpl();
        repository.init("/2021/input06test.txt");

        fishCounterInteractor = new FishCounterInteractor(repository);
    }

    @Test
    void execute_18days_success() {
        var result = fishCounterInteractor.execute(18);

        assertThat(result).isEqualTo(26);
    }

    @Test
    void execute_80days_success() {
        var result = fishCounterInteractor.execute(80);

        assertThat(result).isEqualTo(5934);
    }

    @Test
    void name() throws IOException {
        var repository = new LanternFishRepositoryImpl();
        repository.init("/2021/input06.txt");

        fishCounterInteractor = new FishCounterInteractor(repository);

        var result = fishCounterInteractor.execute(80);

        assertThat(result).isEqualTo(5934);

    }
}
