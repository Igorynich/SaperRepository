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
public class SaperRunner {
    public static void main (String[] args){
        FieldBuilder.getField();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StandardFrame().setVisible(true);
            }
        });
        
        System.out.println("Bombs = "+FieldBuilder.getBombCounter()+"; NoBombs = "+ FieldBuilder.notaBombCounter);
    }
}
