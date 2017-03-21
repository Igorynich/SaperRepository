/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class FieldBuilder {

    static StandardCell[][] field = null;
    static StandardCell[][] shell = null;
    static ArrayList<StandardCell> fieldList = new ArrayList<StandardCell>();
    static ArrayList<StandardCell> shellList = new ArrayList<StandardCell>();
    static Random random = new Random(/*new Date().getTime()*/);
    static int bombCounter = 0;
    static int notaBombCounter = 0;

    public static int getBombCounter() {
        return bombCounter;
    }

    public static int getNotaBombCounter() {
        return notaBombCounter;
    }

    public static void getField() {
        field = new StandardCell[StandardBoard.getSize()[0]][StandardBoard.getSize()[1]];
        shell = new StandardCell[StandardBoard.getSize()[0]][StandardBoard.getSize()[1]];
        createField();
        addNumbers();
        createShell();
        toList(fieldList, field);
        toList(shellList, shell);
        //create collections?
    }

    public static void printList(ArrayList<StandardCell> list) {
        for (StandardCell cell : list){
            System.out.println(list.indexOf(cell)+ "  " +cell);
        }
    }

    private static ArrayList<StandardCell> toList(ArrayList<StandardCell> list, StandardCell[][] array) {
        for (int i = 0; i < StandardBoard.getSize()[0]; i++) {
            for (int j = 0; j < StandardBoard.getSize()[1]; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    public static void createShell() {
        int k = 0;
        for (int i = 0; i < StandardBoard.getSize()[0]; i++) {
            for (int j = 0; j < StandardBoard.getSize()[1]; j++) {
                shell[i][j] = new StandardCell(k * i, k * j, StandardCell.cellType.SHELL);

            }
        }
    }

    static public void createField() {
        for (int i = 0; i < StandardBoard.getSize()[0]; i++) {
            for (int j = 0; j < StandardBoard.getSize()[1]; j++) {
                int ran = random.nextInt(StandardBoard.getBoard());
                if (ran < StandardBoard.getDifficulty()) {
                    //System.out.println("Bomb I and J "+i + " " +j+ " "+StandardBoard.getSize()[0]+" "+StandardBoard.getSize()[1]);
                    field[i][j] = new StandardCell(0, 0, StandardCell.cellType.BOMB);
                    bombCounter++;
                } else {
                    //System.out.println("Hidden I and J "+i + " " +j);
                    field[i][j] = new StandardCell(0, 0, StandardCell.cellType.HIDDEN);
                    notaBombCounter++;
                }
            }
        }
    }

    public static void addNumbers() {
        int number = 0;
        for (int i = 0; i < StandardBoard.getSize()[0]; i++) {
            for (int j = 0; j < StandardBoard.getSize()[1]; j++) {
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
                } else if ((i > 0) && (j == 0) && (i < StandardBoard.getSize()[0] - 1) && (j < StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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
                } else if ((i == 0) && (j > 0) && (i < StandardBoard.getSize()[0] - 1) && (j < StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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
                } else if (((i > 0) && (j > 0)) && (i < StandardBoard.getSize()[0] - 1) && (j < StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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
                } else if (((i > 0) && (j > 0)) && (i == StandardBoard.getSize()[0] - 1) && (j < StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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

                } else if (((i > 0) && (j > 0)) && (i < StandardBoard.getSize()[0] - 1) && (j == StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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
                } else if ((i == StandardBoard.getSize()[0] - 1) && (j == StandardBoard.getSize()[1] - 1) && (field[i][j].getCell() != StandardCell.cellType.BOMB)) {
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
