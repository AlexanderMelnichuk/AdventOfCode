package ru.ama0.adventofcode.y2020.day23;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CupMover {
    private final ICupCircle circle;

    public void moveCups() {
        Cup cupsToExclude = circle.getCurrentCup().getNext();
        Cup cupAfterExclude = cupsToExclude.getNext().getNext().getNext();
        cupsToExclude.getNext().getNext().setNext(cupsToExclude);
        circle.getCurrentCup().setNext(cupAfterExclude);

        int destinationCupNumber = circle.getCurrentCup().getValue();
        do {
            destinationCupNumber--;
            if (destinationCupNumber < 1) {
                destinationCupNumber = circle.getCupsCount();
            }
        } while (destinationCupNumber == cupsToExclude.getValue()
                || destinationCupNumber == cupsToExclude.getNext().getValue()
                || destinationCupNumber == cupsToExclude.getNext().getNext().getValue());
        Cup destinationCup = circle.findCup(destinationCupNumber)
                .orElseThrow(() -> new IllegalStateException("Cup is not found"));
        Cup cupAfterDestination = destinationCup.getNext();
        destinationCup.setNext(cupsToExclude);
        cupsToExclude.getNext().getNext().setNext(cupAfterDestination);
    }
}
