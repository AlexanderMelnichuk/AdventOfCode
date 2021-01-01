package ru.ama0.adventofcode.day21;

import lombok.Getter;
import org.assertj.core.data.MapEntry;
import ru.ama0.adventofcode.day13.math.Pair;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IngredientChecker {

    private static final Pattern LINE =
            Pattern.compile("(?<ingredients>(\\w+ )+)\\(contains (?<allergens>\\w+(, \\w+)*)\\)");

    @Getter
    private Map<String, Set<String>> translations = new HashMap<>();

    public String cleanTranslations() {
        Set<String> processed = new HashSet<>();
        Set<Map.Entry<String, Set<String>>> singularEntries;

        do {
            singularEntries = translations.entrySet().stream()
                    .filter(entry -> entry.getValue().size() == 1 && !processed.contains(entry.getKey()))
                    .collect(Collectors.toSet());
            for (Map.Entry<String, Set<String>> singularEntry : singularEntries) {
                processed.add(singularEntry.getKey());
                for (Map.Entry<String, Set<String>> translationEntry : translations.entrySet()) {
                    if (!translationEntry.getKey().equals(singularEntry.getKey())) {
                        translationEntry.getValue().removeAll(singularEntry.getValue());
                    }
                }
            }
        } while (processed.size() < translations.size() || singularEntries.isEmpty());
        return translations.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(s -> new Pair<>(s, entry.getKey())))
                .sorted(Comparator.comparing(Pair::getRight))
                .map(Pair::getLeft)
                .collect(Collectors.joining(","));
    }

    public int calculate(String fileName) throws IOException {
        List<String> lines = Io.readLines(fileName);
        List<String> ingredients;
        Set<String> ingredientsSet;
        Set<String> allergens;
        List<List<String>> ingredientsBase = new ArrayList<>();
        for (String line : lines) {
            Matcher matcher = LINE.matcher(line);
            if (matcher.find()) {
                allergens = Arrays.stream(matcher.group("allergens").split(", ")).collect(Collectors.toSet());
                ingredients = Arrays.stream(matcher.group("ingredients").split(" ")).collect(Collectors.toList());
                ingredientsBase.add(ingredients);
                for (String allergen : allergens) {
                    ingredientsSet = new HashSet<>(ingredients);
                    if (!translations.containsKey(allergen)) {
                        translations.put(allergen, ingredientsSet);
                    } else {
                        Set<String> existingIngredients = translations.get(allergen);
                        existingIngredients.retainAll(ingredients);
                    }
                }
            } else {
                throw new IllegalStateException("nonmatching " + line);
            }
        }
        Set<String> foundAllergens = new HashSet<>();
        translations.values().forEach(foundAllergens::addAll);
        System.out.println(translations);
        System.out.println(translations.size());
        System.out.println(foundAllergens);
        int countSafe = 0;
        for (List<String> ingredientList : ingredientsBase) {
            for (String ingredient : ingredientList) {
                if (!foundAllergens.contains(ingredient)) {
                    countSafe++;
                }
            }
        }
        return countSafe;
    }
}
