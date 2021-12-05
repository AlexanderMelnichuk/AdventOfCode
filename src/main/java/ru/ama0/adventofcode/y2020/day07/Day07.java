package ru.ama0.adventofcode.y2020.day07;

import lombok.val;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Day07 {
    public static final String CONTAINER = "container";
    public static final String ITEMS = "items";
    public static final String COUNT = "count";
    public static final String NAME = "name";

    private static final String BAG_TO_CHECK_NAME = "shiny gold";

    private static final Pattern BAG_NAME = Pattern.compile("^(?<container>.*) bags contain (?<items>.*)\\.$");
    private static final Pattern ITEM_NAME = Pattern.compile("^(?<count>\\d+) (?<name>.*) bags?$");

    private static final Map<String, Bag> bags = new HashMap<>();
    private static final Set<Bag> reachable = new HashSet<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day07.txt");
        for(String line: lines) {
            val containerMatcher = BAG_NAME.matcher(line);
            if (containerMatcher.find()) {
                String containerName = containerMatcher.group(CONTAINER);
                String[] items = containerMatcher.group(ITEMS).split(", ");
                Bag container = bags.getOrDefault(containerName, new Bag(containerName));
                for (String item: items) {
                    val itemMatcher = ITEM_NAME.matcher(item);
                    if (itemMatcher.find()) {
                        int count = Integer.parseInt(itemMatcher.group(COUNT));
                        String itemName = itemMatcher.group(NAME);
                        Bag itemBag = bags.getOrDefault(itemName, new Bag(itemName));
                        itemBag.getCanBeIn().add(container);
                        container.getContains().add(new BagCount(itemBag, count));
                        bags.put(itemName, itemBag);
                    }
                }
                bags.put(containerName, container);
            }
        }
        Bag bagToCheck = bags.get(BAG_TO_CHECK_NAME);

        traverseUp(bagToCheck);

        System.out.println(bags.size());
        System.out.println(reachable.size() - 1);

        System.out.println(traverseDown(bagToCheck) - 1);
    }

    private static void traverseUp(Bag current) {
        reachable.add(current);
        if (current.getCanBeIn().isEmpty()) {
            return;
        }
        for(Bag bag: current.getCanBeIn()) {
            traverseUp(bag);
        }
    }

    private static long traverseDown(Bag current) {
        if (current.getContains().isEmpty()) {
            return 1;
        }
        int additional = 1;
        for(BagCount bagCount: current.getContains()) {
            additional += bagCount.getCount() * traverseDown(bagCount.getBag());
        }
        return additional;
    }
}
