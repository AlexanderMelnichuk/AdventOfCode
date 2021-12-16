package ru.ama0.adventofcode.y2021.day08.domain;

import com.google.common.collect.Sets;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DigitSectionMapper {

    /**
     * _111
     * 2   3
     * 2   3
     * _444
     * 5   6
     * 5   6
     * _777
     */
    public static final Set<Digit> DIGIT_DEFINITIONS = Set.of(
            new Digit(0, Set.of(1, 2, 3, 5, 6, 7)),
            new Digit(1, Set.of(3, 6)),
            new Digit(2, Set.of(1, 3, 4, 5, 7)),
            new Digit(3, Set.of(1, 3, 4, 6, 7)),
            new Digit(4, Set.of(2, 3, 4, 6)),
            new Digit(5, Set.of(1, 2, 4, 6, 7)),
            new Digit(6, Set.of(1, 2, 4, 5, 6, 7)),
            new Digit(7, Set.of(1, 3, 6)),
            new Digit(8, Set.of(1, 2, 3, 4, 5, 6, 7)),
            new Digit(9, Set.of(1, 2, 3, 4, 6, 7))
    );

    static final Map<Integer, Digit> DIGIT_BY_NUMBER;
    static final Map<Set<Integer>, Digit> DIGIT_BY_SECTIONS;
    static final Map<Integer, Set<Digit>> POSSIBLE_DIGITS_BY_LENGTH;

    static {
        DIGIT_BY_NUMBER = DIGIT_DEFINITIONS.stream()
                .collect(Collectors.toMap(Digit::getNumber, Function.identity()));
        DIGIT_BY_SECTIONS = DIGIT_DEFINITIONS.stream()
                .collect(Collectors.toMap(Digit::getSections, Function.identity()));
        POSSIBLE_DIGITS_BY_LENGTH = DIGIT_DEFINITIONS.stream()
                .collect(Collectors.groupingBy(
                        (Digit definition) -> definition.getSections().size(),
                        Collectors.toCollection(HashSet::new)));
    }

    public Digit digitsMatch(@Nonnull EncodedDigit encodedDigit) {
        return null;
    }

    @Nonnull
    private SectionCharacterMap sectionsMatch(@Nonnull Collection<String> encodedDigits) {
        var encodedDigitsByLength = encodedDigits.stream()
                .map(EncodedDigit::new)
                .collect(Collectors.groupingBy(
                        encodedDigit -> encodedDigit.getId().length(),
                        Collectors.toCollection(HashSet::new)));

        var encodedDigit1 = encodedDigitsByLength.get(2).iterator().next();
        var encodedDigit4 = encodedDigitsByLength.get(4).iterator().next();
        var encodedDigit7 = encodedDigitsByLength.get(3).iterator().next();
        var encodedDigit8 = encodedDigitsByLength.get(7).iterator().next();
        var encodedDigits235 = encodedDigitsByLength.get(5);
        var encodedDigits690 = encodedDigitsByLength.get(6);

        var map = new SectionCharacterMap();

        // Section 1 letter
        var section1Character =
                Sets.difference(encodedDigit7.getCharacters(), encodedDigit1.getCharacters())
                        .iterator().next();
        map.match(section1Character, 1);

        // Section 3 and 6 letters
        var encodedDigit1charactersIterator = encodedDigit1.getCharacters().iterator();
        var digit1CharacterA = encodedDigit1charactersIterator.next();
        var digit1CharacterB = encodedDigit1charactersIterator.next();
        var allExceptDigit1CharacterACharacters =
                Sets.difference(encodedDigit7.getCharacters(), Set.of(digit1CharacterA));
        if (encodedDigits690.stream()
                .map(EncodedDigit::getCharacters)
                .anyMatch(allExceptDigit1CharacterACharacters::containsAll)) {
            map.match(digit1CharacterA, 3);
            map.match(digit1CharacterB, 6);
        } else {
            map.match(digit1CharacterA, 6);
            map.match(digit1CharacterB, 3);
        }

        // Section 5 and 7 letters
        var lowerLeftSectionsCharacters =
                Sets.difference(encodedDigit8.getCharacters(),
                        Sets.union(encodedDigit4.getCharacters(), Set.of(section1Character)));
        var lowerLeftSectionsCharactersIterator =
                lowerLeftSectionsCharacters.iterator();
        var lowerLeftSectionsCharacterA = lowerLeftSectionsCharactersIterator.next();
        var lowerLeftSectionsCharacterB = lowerLeftSectionsCharactersIterator.next();
        var allExceptLowerLeftSectionsCharacterACharacters =
                Sets.difference(encodedDigit8.getCharacters(), Set.of(lowerLeftSectionsCharacterA));
        if (encodedDigits690.stream()
                .map(EncodedDigit::getCharacters)
                .anyMatch(allExceptLowerLeftSectionsCharacterACharacters::containsAll)) {
            map.match(lowerLeftSectionsCharacterA, 5);
            map.match(lowerLeftSectionsCharacterB, 7);
        } else {
            map.match(lowerLeftSectionsCharacterA, 7);
            map.match(lowerLeftSectionsCharacterB, 5);
        }

        // Section 4
        var digit2ExceptSection4characters = Set.of(
                map.getSectionToCharacterMap().get(1),
                map.getSectionToCharacterMap().get(3),
                map.getSectionToCharacterMap().get(5),
                map.getSectionToCharacterMap().get(7));
        var section4Character = encodedDigits235.stream()
                .map(encodedDigit -> Sets.difference(encodedDigit.getCharacters(), digit2ExceptSection4characters))
                .filter(characters -> characters.size() == 1)
                .findFirst().map(characters -> characters.iterator().next())
                .orElseThrow(() -> new IllegalStateException("Algo error!"));
        map.match(section4Character, 4);

        // Section 2
        var section2Character = Sets.difference(encodedDigit4.getCharacters(),
                Set.of(map.getSectionToCharacterMap().get(4), map.getSectionToCharacterMap().get(3),
                        map.getSectionToCharacterMap().get(6)))
                .iterator().next();
        map.match(section2Character, 2);
        return map;
    }

}
