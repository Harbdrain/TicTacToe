package com.danil.tictactoe.model;

import java.util.Scanner;

import com.danil.tictactoe.utils.ConsoleUtils;
import com.danil.tictactoe.utils.coordinates.Coord;

public class HumanPlayer implements Player {
    private String mName;
    private Figure mFigure;
    private final Scanner scanner = ConsoleUtils.scanner;

    public HumanPlayer(String name) {
        mName = name;
        mFigure = Figure.NONE;
    }

    public HumanPlayer(String name, Figure figure) {
        this(name);
        mFigure = figure;
    }

    @Override
    public Coord makeMove() {
        int xAxis, yAxis;
        System.out.print(mName + ": ");
        xAxis = scanner.nextInt();
        yAxis = scanner.nextInt();
        return new Coord(xAxis, yAxis);
    }

    @Override
    public Figure getType() {
        return mFigure;
    }

    @Override
    public void setType(Figure figure) {
        mFigure = figure;
    }

    @Override
    public String getName() {
        return mName;
    }

}
