package com.danil.tictactoe.model;

import java.util.Arrays;

import com.danil.tictactoe.utils.coordinates.Coord;

public class Field {
    private final Figure[] mStorage = new Figure[9];

    public Field() {
        Arrays.fill(mStorage, Figure.NONE);
    }

    public Figure getValue(Coord coord) {
        return mStorage[coord.getX() * 3 + coord.getY()];
    }

    public Figure getValue(int x, int y) {
        return mStorage[x * 3 + y];
    }

    public void setValue(Figure value, Coord coord) {
        this.mStorage[coord.getX() * 3 + coord.getY()] = value;
    }

    public void showField() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i > 0) {
                builder.append('\n');
            }

            char c;
            switch (mStorage[i]) {
                case NOUGHT:
                    c = 'o';
                    break;
                case CROSS:
                    c = 'x';
                    break;
                default:
                    c = '.';
            }

            builder.append(c);
        }
        System.out.println(builder);
    }
}
