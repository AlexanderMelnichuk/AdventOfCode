package ru.ama0.adventofcode.y2021.day14.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PolymerPairs {

    public static final BiFunction<String, Long, Long> ADD_PAIR =
            (p, oldValue) -> (oldValue == null) ? 1 : oldValue + 1;


    private Map<String, Long> pairs;

    public PolymerPairs(String line) {
        pairs = new HashMap<>();
        for (int index = 0; index < line.length() - 1; index++) {
            var pair = String.valueOf(new char[]{ line.charAt(index), line.charAt(index + 1) });
            pairs.compute(pair, ADD_PAIR);
        }
    }

    public void applyRules(Collection<PairInsertionRule> rules) {
        var nextPairs = new HashMap<String, Long>(pairs);
        for (var rule : rules) {
            var previousPairToRemove = rule.getPair();
            var previousPairCount = pairs.getOrDefault(previousPairToRemove, 0L);
            if (previousPairCount > 0L) {
                nextPairs.compute(previousPairToRemove,
                        (pair, pairCount) ->
                                (previousPairCount.equals(pairCount)
                                        ? null
                                        : pairCount - previousPairCount));
                var leftPairToPut = rule.getLeftPair();
                var leftPairCount = nextPairs.getOrDefault(leftPairToPut, 0L);
                nextPairs.put(leftPairToPut, leftPairCount + previousPairCount);
                var rightPairToPut = rule.getRightPair();
                var rightPairCount = nextPairs.getOrDefault(rightPairToPut, 0L);
                nextPairs.put(rightPairToPut, rightPairCount + previousPairCount);
            }
        }
        pairs = nextPairs;
    }

    public Map<String, Long> getPairs() {
        return new HashMap<>(pairs);
    }

}
