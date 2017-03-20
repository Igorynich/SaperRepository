/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.StandardCell.cellType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
        //GroupLayout gpl = new GroupLayout(jPanel1);
        //BorderLayout bl = new BorderLayout();
        //FlowLayout fl = new FlowLayout();
        GridLayout gl = new GridLayout(StandardBoard.size[0], StandardBoard.size[1]);
        //GridBagLayout gbl = new GridBagLayout();
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
        //jPanel1.add(new StandardCell((int) (this.getLocationOnScreen().getX()+10), (int) (this.getLocationOnScreen().getY()+ 10), cellType.SHELL));
//        jPanel1.add(new StandardCell(30, 30, cellType.BOMB));
//        jPanel1.add(new StandardCell(0, 0, cellType.BOMB));
//        jPanel1.add(new StandardCell(0, 25, cellType.BOMB));
//        jPanel1.add(new StandardCell(25, 0, cellType.BOMB));
        System.out.println(FieldBuilder.shell[0][1].getSize());
//        FieldBuilder.printList(FieldBuilder.shellList);
//        FieldBuilder.printList(FieldBuilder.fieldList);
        for (StandardCell cell : FieldBuilder.shellList) {
            jPanel1.add(cell);

//        System.out.println(jPanel1.getComponentCount());
//        for (Component component : jPanel1.getComponents()) {
//            System.out.println(component);
//        }
//            //System.out.println(cell+ "  -  " +FieldBuilder.shellList.indexOf(cell));
            cell.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    FieldBuilder.shellList.set(FieldBuilder.shellList.indexOf(cell), FieldBuilder.fieldList.get(FieldBuilder.shellList.indexOf(cell)));
                    System.out.println("DRAGGED on shellList: " + FieldBuilder.shellList.indexOf(cell) + " ");
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    //FieldBuilder.shellList.indexOf(cell);
                    FieldBuilder.printList(FieldBuilder.shellList);
                    FieldBuilder.printList(FieldBuilder.fieldList);

                    int index = FieldBuilder.shellList.indexOf(cell);
                    if (index != -1) {
                        System.out.println("Clicked Cell N: " + index);
                        System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
                        System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                        FieldBuilder.shellList.set(index, FieldBuilder.fieldList.get(index));

                    } else {
                        System.out.println("FUCCCCC");
                    }
                    
                    //System.out.println("CLICKED in shellList: " + FieldBuilder.shellList.indexOf(cell) + " " + Thread.currentThread()+ " "+ cell.getMousePosition()+" "+ cell.getLocationOnScreen());
                    //System.out.println(index+ " ---- "+ FieldBuilder.shellList.get(index));
                    //revalidate();
                    //jPanel1.repaint();
                    jPanel1.removeAll();
                    //FieldBuilder.printList(FieldBuilder.shellList);
                    for (StandardCell cell : FieldBuilder.shellList) {
                        jPanel1.add(cell);
                    }
                    jPanel1.revalidate();
                    jPanel1.repaint();
                }

            });
        }
        
        
//        FieldBuilder.shellList.set(0, new StandardCell(0, 0, cellType.BOMB));
//        jPanel1.removeAll();
//        for (StandardCell cell : FieldBuilder.shellList) {
//            jPanel1.add(cell);
//        }
//        this.revalidate();
//        this.repaint();
//        for (int i = 0; i < StandardBoard.size[0]; i++) {
//            for (int j = 0; j < StandardBoard.size[1]; j++) {
//                jPanel1.add(FieldBuilder.shell[i][j]);
//                
//                FieldBuilder.shell[i][j].addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        
//                        FieldBuilder.shell[0][0] = FieldBuilder.field[0][0];
//                        System.out.println("CLICKED: " + " ");
//                        jPanel1.removeAll();
//                        for (int i = 0; i < StandardBoard.size[0]; i++) {
//                            for (int j = 0; j < StandardBoard.size[1]; j++) {
//                                jPanel1.add(FieldBuilder.shell[i][j]);
//                                //System.out.println(FieldBuilder.shell[i][j].getCell());
//                            }
//
//                        }
//                        jPanel1.revalidate();
//                        jPanel1.repaint();
//                    }
//
//                });
//                System.out.println(FieldBuilder.shell[i][j].getCell());
//            }
//
//        }
//        jPanel1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int jj = e.getX() / StandardCell.cellSize[1];
//                int ii = e.getY() / StandardCell.cellSize[0];
//                System.out.println("CLICK: " + e.getX() + " " + e.getY() + " " + ii + " " + jj);
//                if (ii > StandardBoard.size[0] - 1) {
//                    ii = StandardBoard.size[0] - 1;
//                }
//                if (jj > StandardBoard.size[1] - 1) {
//                    jj = StandardBoard.size[1] - 1;
//                }
//                FieldBuilder.shell[ii][jj] = FieldBuilder.field[ii][jj];
//                jPanel1.removeAll();
//                for (int i = 0; i < StandardBoard.size[0]; i++) {
//                    for (int j = 0; j < StandardBoard.size[1]; j++) {
//                        jPanel1.add(FieldBuilder.shell[i][j]);
//                        //System.out.println(FieldBuilder.shell[i][j].getCell());
//                    }
//
//                }
//                jPanel1.revalidate();
//                jPanel1.repaint();
//
//            }
//
//        });
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
