/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.StandardCell.cellType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class StandardFrame extends JFrame {

    JPanel jPanel1 = null;
    JButton startButton = null;
    JPanel startingPanel = null;

    public StandardFrame() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, 300, 300);                                             //use Board getSize()
        this.setTitle("SAPER");
        this.add(getStartingPage());
        //this.setContentPane(getStartingPage());

        this.setLocation(1100, 200);

        this.pack();
    }

    private JPanel getContent() {
        jPanel1 = new JPanel();

        //jPanel1.add(startButton);
        //GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        //BorderLayout bl = new BorderLayout();
        //FlowLayout fl = new FlowLayout();
        GridLayout gl = new GridLayout(StandardBoard.size[0], StandardBoard.size[1]);
        jPanel1.setLayout(gl);

//        ArrayList<StandardCell> list = new ArrayList<StandardCell>();
//        for (int i = 0; i < 100; i++) {
//            list.add(new StandardCell(0, 0, cellType.HIDDEN));
//        }
//        for (StandardCell sc : list) {
//            //hc.setBounds(hc.getX(), hc.getY(), 50, 50 );
//            jPanel1.add(sc);
//            //System.out.println(hc + " *** "+ hc.getWidth()+" "+hc.getHeight() + " ");
//        }
        FieldBuilder.shell[3][3] = FieldBuilder.field[3][3];
        for (int i = 0; i < StandardBoard.size[0]; i++) {
            for (int j = 0; j < StandardBoard.size[1]; j++) {
                jPanel1.add(FieldBuilder.shell[i][j]);
                System.out.println(FieldBuilder.shell[i][j].getCell());
            }

        }
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int jj = e.getX() / StandardCell.cellSize[1];
                int ii = e.getY() / StandardCell.cellSize[0];
                System.out.println("CLICK: " + e.getX() + " " + e.getY() + " " + ii + " " + jj);
                if (ii > StandardBoard.size[0] - 1) {
                    ii = StandardBoard.size[0] - 1;
                }
                if (jj > StandardBoard.size[1] - 1) {
                    jj = StandardBoard.size[1] - 1;
                }
                FieldBuilder.shell[ii][jj] = FieldBuilder.field[ii][jj];
                jPanel1.removeAll();
                for (int i = 0; i < StandardBoard.size[0]; i++) {
                    for (int j = 0; j < StandardBoard.size[1]; j++) {
                        jPanel1.add(FieldBuilder.shell[i][j]);
                        //System.out.println(FieldBuilder.shell[i][j].getCell());
                    }

                }
                jPanel1.revalidate();
                jPanel1.repaint();

            }

        });

//        for (int i = 0; i < StandardBoard.size[0]; i++) {
//            for (int j = 0; j < StandardBoard.size[1]; j++) {
//                jPanel1.add(FieldBuilder.field[i][j]);
//            }
//
//        }
        //System.out.println(jPanel1.getComponentCount()+" "+StandardCell.getCellCount()+ " "+ hc3.getPreferredSize().toString()+ " "+ hc2.getPreferredSize().toString());
        //System.out.println(hc3.getBounds()+ " "+ hc2.getBounds());
        return jPanel1;
    }

    private JPanel getStartingPage() {
        startingPanel = new JPanel();

        startButton = new JButton("Start the game!");
        FlowLayout fl = new FlowLayout();
        startingPanel.setLayout(fl);
        startingPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandardFrame jf = new StandardFrame();
                jf.setVisible(true);
                jf.setContentPane(getContent());
                jf.setResizable(false);

                jf.pack();
            }
        });
        return startingPanel;
    }
}
