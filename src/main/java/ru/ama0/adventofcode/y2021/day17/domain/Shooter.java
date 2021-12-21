package ru.ama0.adventofcode.y2021.day17.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Shooter {

    private final Target target;

    public boolean shoot(int xSpeed, int ySpeed) {
        var x = xSpeed;
        var y = ySpeed;
        while(!target.isHit(x, y) && !target.isMissed(x, y)) {
            --ySpeed;
            if (xSpeed > 0) {
                --xSpeed;
            }
            x += xSpeed;
            y += ySpeed;
        }
        return target.isHit(x, y);
    }

}
