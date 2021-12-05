package ru.ama0.adventofcode.y2020.day15;

public class Day15a {

    public static void main(String[] args) {
        String input = "1,20,8,12,0,14";
        ElvenCount elvenCount = new ElvenCount();
        int theNumber = elvenCount.nthNumber(input, 2020);
        System.out.println(theNumber);
    }

}
