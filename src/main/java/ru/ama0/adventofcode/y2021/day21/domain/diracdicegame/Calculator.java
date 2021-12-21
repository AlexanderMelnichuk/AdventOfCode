package ru.ama0.adventofcode.y2021.day21.domain.diracdicegame;

public class Calculator {

    public static final int WINNING_SCORE = 21;
    private static final int[] COMBINATIONS = { 0, 0, 0, 1, 3, 6, 7, 6, 3, 1 };

    // [player1 score][player2 score][player1 position][player2 position]
    // It's always player1's turn for this array.
    WinningsCount[][][][] map = new WinningsCount[WINNING_SCORE][WINNING_SCORE][11][11];

    public WinningsCount fill(int p1Score, int p2Score, int p1Pos, int p2Pos) {
        var cachedWinningsCount = map[p1Score][p2Score][p1Pos][p2Pos];
        if (cachedWinningsCount != null) {
            return cachedWinningsCount;
        }

        long p1Winnings = 0L;
        long p2Winnings = 0L;
        for (int diceSum = 3; diceSum <= 9; diceSum++) {
            var nextP1Pos = nextPos(p1Pos, diceSum);

            var nextP1Score = p1Score + nextP1Pos;
            if (nextP1Score >= WINNING_SCORE) {
                p1Winnings += COMBINATIONS[diceSum];
                continue;
            }

            var furtherWinningsCount = fill(p2Score, nextP1Score, p2Pos, nextP1Pos)
                    .reverse();
            p1Winnings += COMBINATIONS[diceSum] * furtherWinningsCount.getP1Winnings();
            p2Winnings += COMBINATIONS[diceSum] * furtherWinningsCount.getP2Winnings();
        }

        var result = new WinningsCount(p1Winnings, p2Winnings);
        map[p1Score][p2Score][p1Pos][p2Pos] = result;
        return result;
    }

    private int nextPos(int pos, int diceSum) {
        return (pos + diceSum - 1) % 10 + 1;
    }

    public void init() {
        for (int p1Score = 20; p1Score >= 0; --p1Score) {
            for (int p2Score = 20; p2Score >= 0; --p2Score) {
                for (int p1Pos = 1; p1Pos < 10; p1Pos++) {
                    for (int p2Pos = 1; p2Pos < 10; p2Pos++) {
                        fill(p1Score, p2Score, p1Pos, p2Pos);
                    }
                }
            }
        }

    }

}
