package ru.ama0.adventofcode.y2021.day08.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day08.application.ports.DisplayDigitsRepository;
import ru.ama0.adventofcode.y2021.day08.domain.Digit;
import ru.ama0.adventofcode.y2021.day08.domain.DigitDecoder;
import ru.ama0.adventofcode.y2021.day08.domain.EncodedDigit;

@RequiredArgsConstructor
public class DigitSummarizer {

    private final DisplayDigitsRepository repository;

    public long execute() {
        var requests = repository.getAll();
        long sum = 0L;
        for (var request : requests) {
            var digitDecoder = new DigitDecoder(request.getDigitsDictionary());
            sum += request.getRequiredDigits().stream()
                    .map(EncodedDigit::new)
                    .map(digitDecoder::decode)
                    .map(Digit::getNumber)
                    .reduce((x, y) -> x * 10 + y).orElseThrow();
        }
        return sum;
    }

}
