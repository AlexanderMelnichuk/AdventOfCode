package ru.ama0.adventofcode.day22;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day22a {

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day22.txt");

        int lineNumber = 0;
        while (!lines.get(lineNumber++).startsWith("Player ")) {
        }
        Deque<Integer> player1 = new LinkedList<>();
        String line;
        while (!(line = lines.get(lineNumber++)).startsWith("Player ") && !line.isEmpty()) {
            player1.add(Integer.parseInt(line));
        }
        while (!lines.get(lineNumber++).startsWith("Player ")) {
        }
        Deque<Integer> player2 = new LinkedList<>();
        while (lineNumber < lines.size() && !(line = lines.get(lineNumber++)).isEmpty()) {
            player2.add(Integer.parseInt(line));
        }

        Integer card1;
        Integer card2;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            card1 = player1.pop();
            card2 = player2.pop();
            if (card1 > card2) {
                player1.add(card1);
                player1.add(card2);
            } else {
                player2.add(card2);
                player2.add(card1);
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        
        Deque<Integer> winner = (player1.isEmpty()) ? player2 : player1;
        long score = 0;
        int size = winner.size();
        for (int i = 1; i <= size; i++) {
            score += winner.removeLast() * i;
        }
        System.out.println(score);
    }
}
