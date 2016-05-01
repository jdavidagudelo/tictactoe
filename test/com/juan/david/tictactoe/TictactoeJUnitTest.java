/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.david.tictactoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.juan.david.tictactoe.TictactoeNode;

/**
 *
 * @author ubidotsjd
 */
public class TictactoeJUnitTest {

    public TictactoeJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMinimaxEmpty() {
        TictactoeNode node = new TictactoeNode(3, 3);
        System.out.println(TictactoeNode.minimax(node, 9, TictactoeCell.PLAYER));
    }
}
