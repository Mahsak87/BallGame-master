package org.example;

public class Position {
    int col,row;


    public Position(int col) {
        this.col = col;
    }
    public Position(int col, int row) {
        this.row = row;
        this.col = col;
    }


    public int getRow() {
        return row;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
