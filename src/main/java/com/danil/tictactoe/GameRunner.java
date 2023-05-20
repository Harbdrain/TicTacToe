package com.danil.tictactoe;

import com.danil.tictactoe.service.GameLogic;
import com.danil.tictactoe.service.Logic;

class GameRunner {
    public static void main(String[] args) {
        Logic logic = new GameLogic();
        logic.run();
    }
}
