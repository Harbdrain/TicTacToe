package com.danil.tictactoe.service;

import java.util.Scanner;

import com.danil.tictactoe.model.BotPlayer;
import com.danil.tictactoe.model.HumanPlayer;
import com.danil.tictactoe.model.Field;
import com.danil.tictactoe.model.Figure;
import com.danil.tictactoe.model.Player;
import com.danil.tictactoe.utils.ConsoleUtils;
import com.danil.tictactoe.utils.coordinates.Coord;

public class GameLogic implements Logic {
    private final Field mField = new Field();
    private Player[] mPlayers;

    public GameLogic() {
        mPlayers = new Player[2];

        Scanner scanner = ConsoleUtils.scanner;
        System.out.print("Input your name: ");
        String name = scanner.nextLine();
        mPlayers[0] = new HumanPlayer(name, Figure.CROSS);
        mPlayers[1] = new BotPlayer("BOT", Figure.NOUGHT);
    }

    public void run() {
        printWelcomeMessage(mPlayers[0]);

        int turn = 0;
        Winner winner;
        while ((winner = checkWinner()) == null) {
            System.out.println();
            mField.showField();

            Player player = mPlayers[turn];
            Coord playerInput = getPlayerInput(player);
            mField.setValue(player.getType(), playerInput);

            turn ^= 1;
        }

        System.out.println();
        mField.showField();
        if (winner == Winner.DRAW) {
            System.out.println("Draw!");
        } else {
            turn ^= 1;
            System.out.println(mPlayers[turn].getName() + " wins!");
        }
    }

    private Winner checkWinner() {
        boolean checkDraw = true;
        Winner winner = null;

        int sumDiag = 0;
        int sumRDiag = 0;
        for (int i = 0; i < 3; i++) {
            int sumLine = 0;
            int sumColumn = 0;
            for (int j = 0; j < 3; j++) {
                if (mField.getValue(i, j) == Figure.NONE) {
                    checkDraw = false;
                }

                sumLine += mField.getValue(i, j).getValue();
                sumColumn += mField.getValue(j, i).getValue();
            }
            sumDiag += mField.getValue(i, i).getValue();
            sumRDiag += mField.getValue(i, 2 - i).getValue();

            winner = getCrossNoughtWinnerBySum(sumLine);
            if (winner != null) {
                return winner;
            }
            winner = getCrossNoughtWinnerBySum(sumColumn);
            if (winner != null) {
                return winner;
            }
        }

        winner = getCrossNoughtWinnerBySum(sumDiag);
        if (winner != null) {
            return winner;
        }
        winner = getCrossNoughtWinnerBySum(sumRDiag);
        if (winner != null) {
            return winner;
        }

        if (checkDraw) {
            return Winner.DRAW;
        }

        return null;
    }

    private Winner getCrossNoughtWinnerBySum(int sum) {
        switch (sum) {
            case 3:
                return Winner.NOUGHT;
            case 12:
                return Winner.CROSS;
            default:
                return null;
        }
    }

    private Coord getPlayerInput(Player player) {
        Coord input;
        do {
            input = player.makeMove();
        } while (!validateInput(input));
        return input;
    }

    private boolean validateInput(Coord input) {
        return input.getX() > -1 && input.getX() < 3 && input.getY() > -1 && input.getY() < 3
                && mField.getValue(input) == Figure.NONE;
    }

    private void printWelcomeMessage(Player player) {
        System.out.println("Hello, " + player.getName() + "! You are playing for cross. Type in coords [0;2] [0;2].");
    }

    private enum Winner {
        NOUGHT, CROSS, DRAW
    }
}
