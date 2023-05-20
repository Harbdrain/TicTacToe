package com.danil.tictactoe.model;

import java.util.Random;

import com.danil.tictactoe.utils.coordinates.Coord;

public class BotPlayer implements Player {
    private String mName;
    private Figure mFigure;

    private final Random mRandom = new Random();

    public BotPlayer(String name) {
        mName = name;
        mFigure = Figure.NONE;
    }

    public BotPlayer(String name, Figure figure) {
        this(name);
        mFigure = figure;
    }

    @Override
    public Coord makeMove() {
        int xAxis = mRandom.nextInt(3);
        int yAxis = mRandom.nextInt(3);
        return new Coord(xAxis, yAxis);
    }

    @Override
    public Figure getType() {
        return mFigure;
    }

    @Override
    public void setType(Figure fieldType) {
        mFigure = fieldType;
    }

    @Override
    public String getName() {
        return mName;
    }
}
