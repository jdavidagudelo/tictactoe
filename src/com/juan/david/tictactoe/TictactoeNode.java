/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.david.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ubidotsjd
 */
public class TictactoeNode {

    private final List<TictactoeCell> board = new ArrayList<>();
    private final int m;
    private final int n;

    public TictactoeNode(int m, int n) {
        this.m = m;
        this.n = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board.add(TictactoeCell.EMPTY);
            }
        }
    }

    public int getScore(int depth) {
        boolean over = true;
        for (int i = 0; i < m; i++) {
            int f[] = new int[2];
            for (int j = 0; j < n && over; j++) {
                TictactoeCell cell = board.get(i * n + j);
                f[cell == TictactoeCell.PLAYER ? 0 : 1]++;
            }
            if (f[0] == n || f[1] == n) {
                return f[0] == n ? 10 - depth : depth - 10;
            }
        }
        for (int j = 0; j < n; j++) {
            int f[] = new int[2];
            for (int i = 0; i < m && over; i++) {
                TictactoeCell cell = board.get(i * n + j);
                f[cell == TictactoeCell.PLAYER ? 0 : 1]++;
            }
            if (f[0] == n || f[1] == n) {
                return f[0] == n ? 10 - depth : depth - 10;
            }
        }
        int f[] = new int[2];
        for (int i = 1; i < m && over; i++) {
            TictactoeCell cell = board.get(i * n + i);
            f[cell == TictactoeCell.PLAYER ? 0 : 1]++;

        }
        if (f[0] == n || f[1] == n) {
            return f[0] == n ? 10 - depth : depth - 10;
        }
        for (int i = 1; i < m && over; i++) {
            TictactoeCell cell = board.get(i * n + m - i - 1);
            f[cell == TictactoeCell.PLAYER ? 0 : 1]++;
        }
        if (f[0] == n || f[1] == n) {
            return f[0] == n ? 10 - depth : depth - 10;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board.get(i * n + j).toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Move max(Move m1, Move m2) {
        if (m1.compareTo(m2) >= 0) {
            return m1;
        }
        return m2;
    }

    public static Move min(Move m1, Move m2) {
        if (m1.compareTo(m2) <= 0) {
            return m1;
        }
        return m2;
    }

    public static Move minimax(Child node, TictactoeCell cell, int depth) {
        if (node.getNode().over()) {
            return new Move(node.getNode().evaluate(), node.getRow(), node.getColumn(), depth);
        }
        depth++;
        if (cell == TictactoeCell.PLAYER) {
            Move max = new Move(Integer.MIN_VALUE, node.getRow(), node.getColumn(), Integer.MAX_VALUE);
            for (Child child : node.getNode().getChildren(cell)) {
                max = max(max, minimax(child, TictactoeCell.OPPONENT, depth));
            }
            return max;
        } else {
            Child test = null;
            Move min = new Move(Integer.MAX_VALUE, node.getRow(), node.getColumn(), Integer.MIN_VALUE);
            for (Child child : node.getNode().getChildren(cell)) {
                Move current =minimax(child, TictactoeCell.PLAYER, depth); 
                min = min(min, current);
            }
            return min;
        }
    }

    private List<Child> getChildren(TictactoeCell cell) {
        if (cell == TictactoeCell.EMPTY) {
            throw new IllegalArgumentException();
        }
        List<Child> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TictactoeCell current = board.get(i * n + j);
                if (current == TictactoeCell.EMPTY) {
                    result.add(new Child(getChild(i, j, cell), i, j));
                }
            }
        }
        return result;
    }

    private TictactoeNode getChild(int r, int c, TictactoeCell cell) {
        TictactoeNode result = new TictactoeNode(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != r || j != c) {
                    result.setCell(i, j, board.get(i * n + j));
                } else {
                    result.setCell(i, j, cell);
                }
            }
        }
        return result;
    }

    public void setCell(int i, int j, TictactoeCell cell) {
        board.set(i * n + j, cell);
    }

    public boolean over() {
        boolean over = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                over &= board.get(i * n + j) != TictactoeCell.EMPTY;
            }
        }
        if (over) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            TictactoeCell cell = board.get(i * n);
            over = cell != TictactoeCell.EMPTY;
            for (int j = 1; j < n && over; j++) {
                over &= cell == board.get(i * n + j);
            }
            if (over) {
                return true;
            }
        }
        for (int j = 0; j < n; j++) {
            TictactoeCell cell = board.get(j);
            over = cell != TictactoeCell.EMPTY;
            for (int i = 1; i < m && over; i++) {
                over &= cell == board.get(i * n + j);
            }
            if (over) {
                return true;
            }
        }
        TictactoeCell cell = board.get(0);
        over = cell != TictactoeCell.EMPTY;
        for (int i = 1; i < m && over; i++) {
            over &= cell == board.get(i * n + i);
        }
        if (over) {
            return true;
        }
        cell = board.get(n - 1);
        over = cell != TictactoeCell.EMPTY;
        for (int i = 1; i < m && over; i++) {
            over &= cell == board.get(i * n + m - i - 1);
        }
        return over;
    }
    public TictactoeCell get(int i, int j){
        return board.get(i*n + j);
    }
    private int evaluate() {
      int score = 0;
      // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
      score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
      score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
      score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
      score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
      score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
      score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
      score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
      score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
      return score;
   }
    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
      int score = 0;
 
      // First cell
      if (get(row1, col1) == TictactoeCell.PLAYER) {
         score = 1;
      } else if (get(row1, col1) == TictactoeCell.OPPONENT) {
         score = -1;
      }
      // Second cell
      if (get(row2, col2) == TictactoeCell.PLAYER) {
         if (score == 1) {
            score = 10;
         } else if (score == -1) {  // cell1 is oppSeed
            return 0;
         } else {  // cell1 is empty
            score = 1;
         }
      } else if (get(row2, col2) == TictactoeCell.OPPONENT) {
         if (score == -1) { // cell1 is oppSeed
            score = -10;
         } else if (score == 1) { // cell1 is mySeed
            return 0;
         } else {  // cell1 is empty
            score = -1;
         }
      }
 
      // Third cell
      if (get(row3, col3) == TictactoeCell.PLAYER) {
         if (score > 0) {  // cell1 and/or cell2 is mySeed
            score *= 10;
         } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
            return 0;
         } else {  // cell1 and cell2 are empty
            score = 1;
         }
      } else if (get(row3, col3) == TictactoeCell.OPPONENT) {
         if (score < 0) {  // cell1 and/or cell2 is oppSeed
            score *= 10;
         } else if (score > 1) {  // cell1 and/or cell2 is mySeed
            return 0;
         } else {  // cell1 and cell2 are empty
            score = -1;
         }
      }
      return score;
   }
 
}
