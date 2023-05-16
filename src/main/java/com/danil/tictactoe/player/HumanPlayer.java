package com.danil.tictactoe.player;

import java.util.Scanner;

import com.danil.tictactoe.Field;
import com.danil.tictactoe.Field.FieldType;

public class HumanPlayer implements Player {
    public HumanPlayer(String name) {
        mName = name;
    }

    public HumanPlayer(String name, Field.FieldType fieldType) {
        this(name);
        mFieldType = fieldType;
    }

    @Override
    public void makeMove(Field field) {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(mName + ": ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!(x > -1 && x < 3 && y > -1 && y < 3));

        field.setField(x, y, mFieldType);
    }

    @Override
    public void setType(FieldType fieldType) {
        mFieldType = fieldType;
    }

    @Override
    public String getName() {
        return mName;
    }

    private String mName;
    private Field.FieldType mFieldType;
}
