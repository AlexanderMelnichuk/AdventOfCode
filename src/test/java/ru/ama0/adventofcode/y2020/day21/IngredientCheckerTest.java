package ru.ama0.adventofcode.y2020.day21;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCheckerTest {
    private final IngredientChecker ingredientChecker = new IngredientChecker();

    @Test
    void check() throws IOException {
        int count = ingredientChecker.calculate("/2020/day21-test.txt");
        String str = ingredientChecker.cleanTranslations();

        assertEquals(5, count);
        assertEquals("mxmxvkd,sqjhc,fvjkl", str);
    }
}
