package ru.ama0.adventofcode.y2021.day14.infrastructure;

import lombok.Getter;
import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day14.application.ports.PolymerDataRepository;
import ru.ama0.adventofcode.y2021.day14.domain.PairInsertionRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PolymerDataRepositoryImpl implements PolymerDataRepository {

    private static final Pattern PAIR_RULE_PATTERN = Pattern.compile("(?<pair>[A-Z]{2}) -> (?<element>[A-Z])");

    @Getter
    private String template;
    private Map<String, PairInsertionRule> pairInsertionRules;

    public void init(String fileName) throws IOException {
        var lines = Io.readLines(fileName);
        template = lines.get(0);
        pairInsertionRules = lines.stream()
                .filter(PAIR_RULE_PATTERN.asMatchPredicate())
                .map(line -> {
                    var matcher = PAIR_RULE_PATTERN.matcher(line);
                    matcher.find();
                    var pair = matcher.group("pair");
                    var element = matcher.group("element").charAt(0);
                    return new PairInsertionRule(pair, element);
                })
                .collect(Collectors.toMap(PairInsertionRule::getPair, Function.identity()));
    }

    @Override
    public Map<String, PairInsertionRule> getPairInsertionRules() {
        return new HashMap<>(pairInsertionRules);
    }

}
