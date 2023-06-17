package com.danil.tictactoe.model;

import java.util.Random;

import com.danil.tictactoe.utils.coordinates.Coord;

public class BotPlayer implements Player {
    private String name;
    private Figure figure;

    private final Random mRandom = new Random();

    public BotPlayer(String name) {
        this.name = name;
        figure = Figure.NONE;
    }

    public BotPlayer(String name, Figure figure) {
        this(name);
        this.figure = figure;
    }

    @Override
    public Coord makeMove() {
        int xAxis = mRandom.nextInt(3);
        int yAxis = mRandom.nextInt(3);
        return new Coord(xAxis, yAxis);
    }

    @Override
    public Figure getType() {
        return figure;
    }

    @Override
    public void setType(Figure fieldType) {
        figure = fieldType;
    }

    @Override
    public String getName() {
        return name;
    }
}
