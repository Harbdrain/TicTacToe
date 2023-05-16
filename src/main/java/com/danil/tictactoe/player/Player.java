package com.danil.tictactoe.player;

import com.danil.tictactoe.Field;

public interface Player {
    void makeMove(Field field);
    void setType(Field.FieldType fieldType);
    String getName();
}
