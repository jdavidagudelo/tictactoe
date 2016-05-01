/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.david.tictactoe;

/**
 *
 * @author ubidotsjd
 */
public class Child {

    private TictactoeNode node;
    private int row;
    private int column;

    public Child(TictactoeNode node, int row, int column) {
        this.node = node;
        this.row = row;
        this.column = column;
    }

    public TictactoeNode getNode() {
        return node;
    }

    public void setNode(TictactoeNode node) {
        this.node = node;
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
}
