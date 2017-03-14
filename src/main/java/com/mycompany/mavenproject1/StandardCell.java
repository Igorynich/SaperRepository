/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author User
 */
public class StandardCell extends JComponent implements Cell {

    static int[] cellSize = {20, 20};
    private static int cellCount = 0;
    private int x = 0;
    private int y = 0;
    private static int i = 0;
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     */
    public static enum cellType {
        HIDDEN, BOMB, QUESTION, NUMBER, SHELL, BOMB_EXPLODE
    };
    private cellType cell = cellType.HIDDEN;

    public cellType getCell() {
        return cell;
    }

    @Override
    protected void paintComponent(Graphics gr) {
        //super.paintComponent(gr); //To change body of generated methods, choose Tools | Templates.
        switch (this.cell) {
            case HIDDEN: {
                drawNoBomb(gr, x, y);
            }
            break;
            case BOMB: {
                drawBomb(gr, x, y);
            }
            break;
            case QUESTION: {
                drawQuestion(gr, x, y);
            }
            break;
            case NUMBER: {
                drawNumber(gr, x, y, number);
            }
            break;
            case SHELL: {
                drawShell(gr, x, y);
            }break;
            case BOMB_EXPLODE:{
                drawBombExplode(gr, x, y);
            }
        }

        //sc.drawNumber(gr, x, y, i);
        //System.out.println("HiddenCell calling to draw "+x+" "+y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(cellSize[0] , cellSize[1] ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {

        return ("HiddenCell N=" + i++ + " " + Integer.toString(x) + " " + Integer.toString(y)); //To change body of generated methods, choose Tools | Templates.
    }

//    public StandardCell() {
//        cellCount++;
//    }
    public StandardCell(int x, int y, cellType cell) {
        this.x = x;
        this.y = y;
        this.cell = cell;
        cellCount++;
    }

    public static int getCellCount() {
        return cellCount;
    }

    @Override
    public void setCellSize(int x, int y) {
        this.cellSize[0] = x;
        this.cellSize[1] = y;
    }

    @Override
    public int[] getCellSize() {
        return cellSize;
    }

    @Override
    public void drawNoBomb(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, this.getCellSize()[0], this.getCellSize()[1], false);
        //System.out.println("StandardCell drawing hidden with "+x+" "+y);
        //g.drawString("*", (x+this.getCellSize()[0])/2 , (y+this.getCellSize()[1]));

    }

    @Override
    public void drawBomb(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], false);
        g.drawString("*", (x + this.cellSize[0]) / 2, (y + this.cellSize[1]));
    }

    @Override
    public void drawNumber(Graphics gr, int x, int y, int number) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], false);
        String str = Integer.toString(number);
        g.drawString(str, (x + this.cellSize[0]) / 2, (y + this.cellSize[1]));
    }

    @Override
    public void drawQuestion(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], true);
        g.drawString("?", (x + this.cellSize[0]) / 2, (y + this.cellSize[1]));
    }

    @Override
    public void drawBombExplode(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], true);
        g.drawString("X", (x + this.cellSize[0]) / 2, (y + this.cellSize[1]));
    }

    @Override
    public void drawShell(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.PINK);
        g.draw3DRect(x, y, this.getCellSize()[0], this.getCellSize()[1], true);
    }

    

}