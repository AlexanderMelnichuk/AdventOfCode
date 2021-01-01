package ru.ama0.adventofcode.day23;

public class Day23b {
    public static void main(String[] args) {
        ICupCircle circle = new BigCupCircle("476138259");
        System.out.println(circle.toString(999_999));
        CupMover cupMover = new CupMover(circle);
        for (int i = 0; i < 10_000_000; i++) {
            cupMover.moveCups();
            circle.nextCurrent();
        }

        Cup one = circle.findCup(1).get();
        int first = one.getNext().getValue();
        int second = one.getNext().getNext().getValue();
        System.out.println(first + " " + second);
        System.out.println((long)first * (long)second);
    }
}
