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
public class Tictactoe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TictactoeNode node = new TictactoeNode(3, 3);
        node.setCell(1, 0, TictactoeCell.PLAYER);
        node.setCell(2, 0, TictactoeCell.PLAYER);
        node.setCell(2, 1, TictactoeCell.OPPONENT);
        node.setCell(2, 2, TictactoeCell.OPPONENT);
        Child c = new Child(node, 0, 0);
        Move move = TictactoeNode.minimax(c, TictactoeCell.PLAYER, 0);
        System.out.println(node);
        System.out.println(move);
    }
    
}
