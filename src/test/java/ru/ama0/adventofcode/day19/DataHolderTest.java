package ru.ama0.adventofcode.day19;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DataHolderTest {

    @Test
    void part1test() throws IOException {
        DataHolder dataHolder = DataHolder.loadFrom("/day19-test.txt");
        int count = dataHolder.complyingCount();

        assertThat(count).isEqualTo(2);
    }

    @Test
    void part2test1() throws IOException {
        DataHolder dataHolder = DataHolder.loadFrom("/day19-test2-1.txt");
        int count = dataHolder.complyingCount();

        assertThat(count).isEqualTo(3);
    }

    @Test
    void part2test2() throws IOException {
        DataHolder dataHolder = DataHolder.loadFrom("/day19-test2-2.txt");
        int count = dataHolder.complyingCount();

        assertThat(count).isEqualTo(12);
    }
}