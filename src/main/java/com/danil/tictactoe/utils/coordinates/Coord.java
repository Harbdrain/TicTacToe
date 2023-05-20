package com.danil.tictactoe.utils.coordinates;

public class Coord {
    private int mX;
    private int mY;

    public Coord(int x, int y) {
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public void setXY(int x, int y) {
        mX = x;
        mY = y;
    }
}
