package com.danil.tictactoe.player;

import java.util.Random;

import com.danil.tictactoe.Field;
import com.danil.tictactoe.Field.FieldType;

public class BotPlayer implements Player {
    public BotPlayer(String name) {
        mName = name;
    }

    public BotPlayer(String name, Field.FieldType fieldType) {
        this(name);
        mFieldType = fieldType;
    }

    @Override
    public void makeMove(Field field) {
        Random random = new Random();

        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (field.getRawField(x, y) != 0);

        System.out.println(mName + ": " + x + " " + y);
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
