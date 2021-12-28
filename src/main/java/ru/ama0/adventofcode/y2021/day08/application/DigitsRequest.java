package ru.ama0.adventofcode.y2021.day08.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class DigitsRequest {

    private final Collection<String> digitsDictionary;
    private final List<String> requiredDigits;

}
