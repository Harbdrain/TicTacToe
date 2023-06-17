package com.danil.tictactoe.model;

import java.util.Arrays;

import com.danil.tictactoe.utils.coordinates.Coord;

public class Field {
    private final Figure[] storage = new Figure[9];

    public Field() {
        Arrays.fill(storage, Figure.NONE);
    }

    public Figure getValue(Coord coord) {
        return storage[coord.getX() * 3 + coord.getY()];
    }

    public Figure getValue(int x, int y) {
        return storage[x * 3 + y];
    }

    public void setValue(Figure value, Coord coord) {
        this.storage[coord.getX() * 3 + coord.getY()] = value;
    }

    public void showField() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i > 0) {
                builder.append('\n');
            }

            char c;
            switch (storage[i]) {
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
