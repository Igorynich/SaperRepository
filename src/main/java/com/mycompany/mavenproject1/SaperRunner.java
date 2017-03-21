/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class SaperRunner {

    
    
    public static void main(String[] args) {
        //FieldBuilder.getField();

        java.awt.EventQueue.invokeLater(new SaperFieldThread());
        System.out.println("Hello!");
        System.out.println("Bombs = " + FieldBuilder.getBombCounter() + "; NoBombs = " + FieldBuilder.notaBombCounter);
    }
    
}
