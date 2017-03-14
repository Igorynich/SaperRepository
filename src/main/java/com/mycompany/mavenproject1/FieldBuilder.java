/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.sun.glass.ui.Size;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author User
 */
public class FieldBuilder {

    static StandardCell[][] field = new StandardCell[StandardBoard.size[0]][StandardBoard.size[1]];
    static StandardCell[][] shell = new StandardCell[StandardBoard.size[0]][StandardBoard.size[1]];
    static Random random = new Random(/*new Date().getTime()*/);
    static int bombCounter = 0;
    static int notaBombCounter = 0;

    public static int getBombCounter() {
        return bombCounter;
    }

    public static int getNotaBombCounter() {
        return notaBombCounter;
    }

    public static void getField(){
        createField();
        addNumbers();
        createShell();
    }
    
    public static void createShell() {
        for (int i = 0; i < StandardBoard.size[0]; i++) {
            for (int j = 0; j < StandardBoard.size[1]; j++) {
                shell[i][j] = new StandardCell(0, 0, StandardCell.cellType.SHELL);
                
            }
        }
    }

    static public void createField() {
        for (int i = 0; i < StandardBoard.size[0]; i++) {
            for (int j = 0; j < StandardBoard.size[1]; j++) {
                int ran = random.nextInt(StandardBoard.board);
                if (ran < StandardBoard.difficulty) {
                    field[i][j] = new StandardCell(0, 0, StandardCell.cellType.BOMB);
                    bombCounter++;
                } else {
                    field[i][j] = new StandardCell(0, 0, StandardCell.cellType.HIDDEN);
                    notaBombCounter++;
                }
            }
        }
    }

    public static void addNumbers() {
        int number = 0;
        for (int i = 0; i < StandardBoard.size[0]; i++) {
            for (int j = 0; j < StandardBoard.size[1]; j++) {
                if ((i == 0) && (j == 0) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i + 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                } else if ((i > 0) && (j == 0) && (i < StandardBoard.size[0] - 1) && (j < StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i + 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                } else if ((i == 0) && (j > 0) && (i < StandardBoard.size[0] - 1) && (j < StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i + 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                } else if (((i > 0) && (j > 0)) && (i < StandardBoard.size[0] - 1) && (j < StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                } else if (((i > 0) && (j > 0)) && (i == StandardBoard.size[0] - 1) && (j < StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j + 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }

                } else if (((i > 0) && (j > 0)) && (i < StandardBoard.size[0] - 1) && (j == StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i + 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i + 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                } else if ((i == StandardBoard.size[0] - 1) && (j == StandardBoard.size[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
                    if (field[i - 1][j].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (field[i - 1][j - 1].getCell() == StandardCell.cellType.BOMB) {
                        number++;
                    }
                    if (number > 0) {
                        StandardCell sc = new StandardCell(0, 0, StandardCell.cellType.NUMBER);
                        sc.setNumber(number);
                        field[i][j] = sc;
                        number = 0;
                    }
                }

            }
        }
    }
}
