package ru.ama0.adventofcode.day23;

public class Day23a {
    public static void main(String[] args) {
        ICupCircle circle = new SmallCupCircle("476138259");
        System.out.println(circle);
        System.out.println(circle.findCup(2));
        CupMover cupMover = new CupMover(circle);
        for (int i = 0; i < 100; i++) {
            cupMover.moveCups();
            circle.nextCurrent();
        }
        System.out.println(circle.toString());
    }
}
