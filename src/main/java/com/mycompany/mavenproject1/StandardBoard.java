/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author User
 */
public class StandardBoard {
    
    static int[] size = {10, 10};
    static int board = size[0]*size[1];
    static int difficulty = 25;

   
    public static void setSize(int x, int y) {
        StandardBoard.size[0] = x;
        StandardBoard.size[1] = y;
    }

    
    public static void setDifficulty(int p) {
        StandardBoard.difficulty = p;
    }

    
    public static int[] getSize() {
        return StandardBoard.size;
    }

    
    public static int getDifficulty() {
        return StandardBoard.difficulty;
    }
    
}
