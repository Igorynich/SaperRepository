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
public class StandardBoard implements Board{
    
    static int[] size = {10, 10};
    static int board = size[0]*size[1];
    static int difficulty = 25;

    @Override
    public void setSize(int x, int y) {
        this.size[0] = x;
        this.size[1] = y;
    }

    @Override
    public void setDifficulty(int p) {
        this.difficulty = p;
    }

    @Override
    public int[] getSize() {
        return this.size;
    }

    @Override
    public int getDifficulty() {
        return this.difficulty;
    }
    
}
