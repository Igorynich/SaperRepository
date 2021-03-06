/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;

/**
 *
 * @author User
 */
public class StandardCell extends JComponent{

    private static int[] cellSize = {20, 20};
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
        HIDDEN, BOMB, QUESTION, NUMBER, SHELL, BOMB_EXPLODE, HIDDEN_CHECKED
    };
    private cellType cell = cellType.HIDDEN;

    public cellType getCell() {
        return cell;
    }

//    @Override
//    public boolean contains(int x, int y) {
//        if ((x > 0) && (y > 0) && (x < this.getWidth())&&(y< getHeight())) {
//            return true;
//        }
//        return false;
//
//    }
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr); //To change body of generated methods, choose Tools | Templates.
        switch (this.cell) {
            case HIDDEN: {
                drawNoBomb(gr, x, y);
            }
            break;
            case HIDDEN_CHECKED: {
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
            }
            break;
            case BOMB_EXPLODE: {
                drawBombExplode(gr, x, y);
            }
        }

        //sc.drawNumber(gr, x, y, i);
        //System.out.println("HiddenCell calling to draw "+x+" "+y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(cellSize[0] + 1, cellSize[1] + 1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {

        return ("Cell N=" + i++ + " " + Integer.toString(x) + " " + Integer.toString(y) + " " + getCell() + " " + getCellCount()); //To change body of generated methods, choose Tools | Templates.
    }

//    public StandardCell() {
//        cellCount++;
//    }
    /**
     *
     * @param x X coordinate (left top coreber)
     * @param y Y coordinate
     * @param cell cellType enum - Type of the cell (bomb, hidden, number etc)
     */
    public StandardCell(int x, int y, cellType cell) {
        this.x = x;
        this.y = y;
        this.cell = cell;
        cellCount++;
        //this.setSize(20, 20);
        //this.setBounds(x, y, 22, 22);
        //this.setPreferredSize(new Dimension(20, 20));
        //this.setOpaque(true);
        //this.setEnabled(true);
        //this.setVisible(true);
        //setBorder(BorderFactory.createTitledBorder("Node"));

    }

    public static int getCellCount() {
        return cellCount;
    }

    public static void setCellSize(int x, int y) {
        cellSize[0] = x;
        cellSize[1] = y;
    }

    
    public int[] getCellSize() {
        return cellSize;
    }

    
    public void drawNoBomb(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        //g.fill3DRect(x, y, this.getCellSize()[0], this.getCellSize()[1], false);
        g.draw3DRect(x, y, this.getCellSize()[0], this.getCellSize()[1], false);
        //System.out.println("StandardCell drawing hidden with "+x+" "+y);
        //g.drawString("*", (x+this.getCellSize()[0])/2 , (y+this.getCellSize()[1]));

    }

    
    public void drawBomb(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.RED);
        //g.fill3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], false);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], false);
        g.setFont(new Font("Courier New", Font.TYPE1_FONT, cellSize[0]));
        g.drawString("*", (x + this.cellSize[0]) / 4, (y + this.cellSize[1]));
    }

    
    public void drawNumber(Graphics gr, int x, int y, int number) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], false);
        switch (number) {
            case 1:
                g.setPaint(Color.BLUE);
                break;
            case 2:
                g.setPaint(Color.ORANGE);
                break;
            case 3:
                g.setPaint(Color.CYAN);
                break;
            case 4:
                g.setPaint(Color.magenta);
                break;
            case 5:
                g.setPaint(Color.GREEN);
                break;
            default:
                g.setPaint(Color.BLACK);
                break;
        }
        //g.setPaint(Color.BLUE);
        String str = Integer.toString(number);
        g.setFont(new Font("Courier New", Font.TYPE1_FONT, cellSize[0]));
        g.drawString(str, (x + this.cellSize[0]) / 4, (y + this.cellSize[1]));
    }

    
    public void drawQuestion(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.PINK);
        g.draw3DRect(x, y, x + this.getCellSize()[0], y + this.getCellSize()[1], true);
        g.setPaint(Color.DARK_GRAY);
        g.setFont(new Font("Courier New", Font.TYPE1_FONT, cellSize[0]));
        g.drawString("?", (x + this.getCellSize()[0]) / 4, (y + this.getCellSize()[1]));
    }

   
    public void drawBombExplode(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.BLUE);
        g.draw3DRect(x, y, x + this.cellSize[0], y + this.cellSize[1], true);
        g.setPaint(Color.RED);
        g.fillRect(x, y, x + this.cellSize[0], y + this.cellSize[1]);
        g.setPaint(Color.BLACK);
        g.setFont(new Font("Courier New", Font.TYPE1_FONT, cellSize[0]));
        g.drawString("X", (x + this.cellSize[0]) / 4, (y + this.cellSize[1]));
    }

    
    public void drawShell(Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setPaint(Color.PINK);
        g.draw3DRect(x, y, this.getCellSize()[0], this.getCellSize()[1], true);
    }

}
