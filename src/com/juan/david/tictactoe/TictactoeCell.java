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
public class TictactoeCell {
    public static final TictactoeCell PLAYER = new TictactoeCell("O");
    public static final TictactoeCell OPPONENT = new TictactoeCell("X");
    public static final TictactoeCell EMPTY = new TictactoeCell("_");
    private String name;
    public TictactoeCell(){
    }
    public TictactoeCell(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
