package com.danil.tictactoe;

import java.util.Scanner;

import com.danil.tictactoe.player.BotPlayer;
import com.danil.tictactoe.player.HumanPlayer;
import com.danil.tictactoe.player.Player;

class GameLogic {
    GameLogic() {
    }

    public void run() {
        loop();
        switch (mWinner) {
            case CROSS:
                System.out.println("Cross wins!");
                break;
            case NOUGHT:
                System.out.println("Nought wins!");
                break;
            case DRAW:
                System.out.println("Draw!");
                break;
            case NONE:
                System.out.println("Something gone wrong");
                break;
        }
    }

    public void init() {
        mPlayers = new Player[2];

        System.out.print("Input your name: ");
        Scanner scanner = Utils.scanner;
        String name = scanner.nextLine();
        mPlayers[0] = new HumanPlayer(name, Field.FieldType.CROSS);
        mPlayers[1] = new BotPlayer("RandBot", Field.FieldType.NOUGHT);
        mWinner = Field.Winner.NONE;
        mField = new Field();

        printWelcomeMessage(mPlayers[0]);
    }

    private void loop() {
        mExit = false;
        int turn = 0;
        render();
        while (!mExit) {
            handleInput(mPlayers[turn % 2]);
            update();
            render();
            turn++; // might be bad if game runs for too many turns, but in our case we will be ok.
        }
    }

    private void handleInput(Player player) {
        player.makeMove(mField);
    }

    private void update() {
        mWinner = mField.calcWinner();
        if (mWinner != Field.Winner.NONE) {
            mExit = true;
        }
    }

    private void render() {
        System.out.println(mField);
    }

    private void printWelcomeMessage(Player player) {
        System.out.println("Hello, " + player.getName() + "! You are playing for cross. Type in coords [0;2] [0;2].");
    }

    private boolean mExit;
    private Field mField;
    private Player[] mPlayers;
    private Field.Winner mWinner;
}
