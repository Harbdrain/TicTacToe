package com.danil.tictactoe.model;

import java.util.Scanner;

import com.danil.tictactoe.utils.ConsoleUtils;
import com.danil.tictactoe.utils.coordinates.Coord;

public class HumanPlayer implements Player {
    private String name;
    private Figure figure;
    private final Scanner scanner = ConsoleUtils.scanner;

    public HumanPlayer(String name) {
        this.name = name;
        figure = Figure.NONE;
    }

    public HumanPlayer(String name, Figure figure) {
        this(name);
        this.figure = figure;
    }

    @Override
    public Coord makeMove() {
        int xAxis, yAxis;
        System.out.print(name + ": ");
        xAxis = scanner.nextInt();
        yAxis = scanner.nextInt();
        return new Coord(xAxis, yAxis);
    }

    @Override
    public Figure getType() {
        return this.figure;
    }

    @Override
    public void setType(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
