package com.danil.tictactoe.model;

import com.danil.tictactoe.utils.coordinates.Coord;

public interface Player {
    Coord makeMove();

    void setType(Figure figure);

    String getName();

    Figure getType();
}
