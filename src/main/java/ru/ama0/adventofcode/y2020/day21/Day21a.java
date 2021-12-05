package ru.ama0.adventofcode.y2020.day21;

import java.io.IOException;

public class Day21a {
    public static void main(String[] args) throws IOException {
        IngredientChecker ingredientChecker = new IngredientChecker();
        System.out.println(ingredientChecker.calculate("/day21.txt"));
        System.out.println(ingredientChecker.cleanTranslations());
    }
}
