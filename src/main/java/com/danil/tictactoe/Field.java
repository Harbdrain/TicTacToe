package com.danil.tictactoe;

public class Field {
    public Field() {
        mField = new int[9];
    }

    public void setField(int x, int y, FieldType fieldType) {
        if (!(x > -1 && x < 4 && y > -1 && y < 4)) {
            System.out.println("Field.class:setField(): Bad point.");
            return;
        }
        mField[x * 3 + y] = fieldType.getValue();
    }

    public int getRawField(int x, int y) {
        if (!(x > -1 && x < 4 && y > -1 && y < 4)) {
            System.out.println("Field.class:getRawField(): Bad point.");
            return -1;
        }
        return mField[x * 3 + y];
    }

    public Winner calcWinner() {
        boolean checkDraw = true;
        for (int i = 0; i < 3; i++) {
            int sumLine = 0;
            int sumColumn = 0;
            for (int j = 0; j < 3; j++) {
                if (mField[i * 3 + j] == 0) {
                    checkDraw = false;
                }

                sumLine += mField[i * 3 + j];
                sumColumn += mField[j * 3 + i];
            }

            Winner winner = getCrossNoughtWinnerBySum(sumLine);
            if (winner != Winner.NONE) {
                return winner;
            }
            winner = getCrossNoughtWinnerBySum(sumColumn);
            if (winner != Winner.NONE) {
                return winner;
            }
        }
        if (checkDraw) {
            return Winner.DRAW;
        }

        int sumDiag = 0;
        int sumRDiag = 0;
        for (int i = 0; i < 3; i++) {
            sumDiag += mField[i * 3 + i];
            sumRDiag += mField[i * 3 + (2 - i)];
        }

        Winner winner = getCrossNoughtWinnerBySum(sumDiag);
        if (winner != Winner.NONE) {
            return winner;
        }
        winner = getCrossNoughtWinnerBySum(sumRDiag);
        if (winner != Winner.NONE) {
            return winner;
        }

        return Winner.NONE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i > 0) {
                builder.append('\n');
            }

            char c;
            switch (mField[i]) {
                case 1:
                    c = 'o';
                    break;
                case 4:
                    c = 'x';
                    break;
                default:
                    c = '.';
            }

            builder.append(c);
        }
        return builder.toString();
    }

    public enum FieldType {
        NOUGHT(1), CROSS(4), NONE(0);

        private int value;

        FieldType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Winner {
        NOUGHT, CROSS, DRAW, NONE;
    }

    private Winner getCrossNoughtWinnerBySum(int sum) { // name too long, but will do.
        switch (sum) {
            case 3:
                return Winner.NOUGHT;
            case 12:
                return Winner.CROSS;
            default:
                return Winner.NONE;
        }
    }

    private int[] mField;
}
