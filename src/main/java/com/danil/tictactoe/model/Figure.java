package com.danil.tictactoe.model;

public enum Figure {
    NOUGHT(1), CROSS(4), NONE(0);

    private final int value;

    Figure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
