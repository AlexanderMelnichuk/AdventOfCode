package ru.ama0.adventofcode.y2020;

import lombok.val;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day04 {

    private static final Set<String> FIELDS = Set.of(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid");
    private static final Pattern HEIGHT_CM = Pattern.compile("(?<h>\\d+)cm");
    private static final Pattern HEIGHT_IN = Pattern.compile("(?<h>\\d+)in");


    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/2020/day04.txt");
        int validPassports1 = 0;
        int validPassports2 = 0;
        Map<String, String> pairs = new HashMap<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                if (isValid1(pairs)) {
                    validPassports1++;
                }
                if (isValid2(pairs)) {
                    validPassports2++;
                }
                pairs = new HashMap<>();
                continue;
            }
            Map<String, String> newPairs = Arrays.stream(line.split(" "))
                    .map(kv -> kv.split(":"))
                    .collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
            pairs.putAll(newPairs);
        }

        // Last one
        if (isValid1(pairs)) {
            validPassports1++;
        }
        if (isValid2(pairs)) {
            validPassports2++;
        }

        System.out.println(validPassports1);
        System.out.println(validPassports2);
    }

    private static boolean isValid1(Map<String, String> map) {
        return map.keySet().containsAll(FIELDS);
    }

    private static boolean isValid2(Map<String, String> map) {
        return isValid1(map)
                && isInRange(map.get("byr"), 1920, 2002)
                && isInRange(map.get("iyr"), 2010, 2020)
                && isInRange(map.get("eyr"), 2020, 2030)
                && (validHeight(HEIGHT_CM, map.get("hgt"), 150, 193)
                    || validHeight(HEIGHT_IN, map.get("hgt"), 59, 76))
                && map.get("hcl").matches("^#[0-9a-f]{6}$")
                && map.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")
                && map.get("pid").matches("^\\d{9}$");
    }

    private static boolean isInRange(String str, int min, int max) {
        try {
            int num = Integer.parseInt(str);
            return num >= min && num <= max;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean validHeight(Pattern pattern, String value, int min, int max) {
        val matcher = pattern.matcher(value);
        return matcher.find() && isInRange(matcher.group("h"), min, max);
    }

}
