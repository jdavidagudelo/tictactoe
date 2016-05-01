/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.david.tictactoe;

public class Move implements Comparable<Move>{

    private int score;
    private int row;
    private int column;
    private int depth;
    public Move(int score, int row, int column, int depth) {
        this.score = score;
        this.row = row;
        this.column = column;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString(){
        return score + " ("+row+", "+column+")";
    }

    @Override
    public int compareTo(Move o) {
        if(Integer.compare(depth, o.depth) !=  0){
            return Integer.compare(o.depth, depth);
        }
        if(Integer.compare(score, o.score) != 0){
            return Integer.compare(score, o.score);
        }
        if(Integer.compare(row, o.row) != 0){
            return Integer.compare(row, o.row);
        }
        return Integer.compare(column, o.column);
    }
}
