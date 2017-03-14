/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Graphics;

/**
 *
 * @author User
 */
public interface Cell {
    void setCellSize (int x, int y);
    int[] getCellSize();
    void drawNoBomb(Graphics gr, int x, int y);
    void drawBomb(Graphics gr, int x, int y);
    void drawNumber(Graphics gr, int x, int y, int number);
    void drawQuestion(Graphics gr, int x, int y);
    void drawBombExplode(Graphics gr, int x, int y);
    void drawShell(Graphics gr, int x, int y);
}
