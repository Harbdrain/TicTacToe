package com.danil.tictactoe.model;

import com.danil.tictactoe.utils.coordinates.Coord;

public interface Player {
    Coord makeMove();

    Figure getType();

    void setType(Figure figure);

    String getName();
}
