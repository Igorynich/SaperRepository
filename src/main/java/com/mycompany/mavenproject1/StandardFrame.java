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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
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
    JPanel base = null;
    JLayeredPane layPane = null;
    OverlayLayout overlayLayout = null;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    public StandardFrame() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, 300, 300);                                             //use Board getSize()
        //this.setTitle("SAPER");

        //overlayLayout.addLayoutComponent("Starting Panle", getStartingPage());
        //this.add(getStartingPage());
        //this.setLayout(new BorderLayout());
//        layPane = new JLayeredPane();
//        this.add(layPane);
//        //layPane.setBounds(0 , 0, 300, 400);
//        //this.setContentPane(layPane);
//        layPane.setPreferredSize(new Dimension(200, 300));
//        //layPane.setVisible(true);
//        //layPane.setName("LayPane");
//        layPane.setBorder(BorderFactory.createTitledBorder(
//                "Move the Mouse to Move Duke"));
//        layPane.setLayout(new FlowLayout());
//        layPane.add(getStartingPage(), 1);
//        //getStartingPage().setBounds(0, 0, 100, 100);
//        //getStartingPage().setBorder(BorderFactory.createTitledBorder(
//        //        "startinpane"));
//        layPane.add(getContent(), 2);
        //base = new JPanel(new Lay);
        //this.add(overlayLayout);
        //this.add(getStartingPage());
        this.setLocation((int)width/2, (int)height/4);

    }

//    private JPanel getContent() {
//        jPanel1 = new JPanel();
//
//        //jPanel1.add(startButton);
//        //GroupLayout gpl = new GroupLayout(jPanel1);
//        //BorderLayout bl = new BorderLayout();
//        //FlowLayout fl = new FlowLayout();
//        GridLayout gl = new GridLayout(StandardBoard.size[0], StandardBoard.size[1]);
//        //GridBagLayout gbl = new GridBagLayout();
//        jPanel1.setLayout(gl);
//        //        ArrayList<StandardCell> list = new ArrayList<StandardCell>();
//        //        for (int i = 0; i < 100; i++) {
//        //            list.add(new StandardCell(0, 0, cellType.HIDDEN));
//        //        }
//        //        for (StandardCell sc : list) {
//        //            //hc.setBounds(hc.getX(), hc.getY(), 50, 50 );
//        //            jPanel1.add(sc);
//        //            //System.out.println(hc + " *** "+ hc.getWidth()+" "+hc.getHeight() + " ");
//        //        }
//        //jPanel1.add(new StandardCell((int) (this.getLocationOnScreen().getX()+10), (int) (this.getLocationOnScreen().getY()+ 10), cellType.SHELL));
////        jPanel1.add(new StandardCell(30, 30, cellType.BOMB));
////        jPanel1.add(new StandardCell(0, 0, cellType.BOMB));
////        jPanel1.add(new StandardCell(0, 25, cellType.BOMB));
////        jPanel1.add(new StandardCell(25, 0, cellType.BOMB));
//        System.out.println(FieldBuilder.shell[0][1].getSize());
////        FieldBuilder.printList(FieldBuilder.shellList);
////        FieldBuilder.printList(FieldBuilder.fieldList);
//        for (StandardCell cell : FieldBuilder.shellList) {
//            jPanel1.add(cell);
//
////        System.out.println(jPanel1.getComponentCount());
////        for (Component component : jPanel1.getComponents()) {
////            System.out.println(component);
////        }
////            //System.out.println(cell+ "  -  " +FieldBuilder.shellList.indexOf(cell));
//            cell.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void mouseDragged(MouseEvent e) {
//                    FieldBuilder.shellList.set(FieldBuilder.shellList.indexOf(cell), FieldBuilder.fieldList.get(FieldBuilder.shellList.indexOf(cell)));
//                    System.out.println("DRAGGED on shellList: " + FieldBuilder.shellList.indexOf(cell) + " ");
//                }
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    //FieldBuilder.shellList.indexOf(cell);
//                    FieldBuilder.printList(FieldBuilder.shellList);
//                    FieldBuilder.printList(FieldBuilder.fieldList);
//
//                    int index = FieldBuilder.shellList.indexOf(cell);
//                    if (index != -1) {
//                        System.out.println("Clicked Cell N: " + index);
//                        System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                        System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
//                        FieldBuilder.shellList.set(index, FieldBuilder.fieldList.get(index));
//
//                    } else {
//                        System.out.println("FUCCCCC");
//                    }
//
//                    //System.out.println("CLICKED in shellList: " + FieldBuilder.shellList.indexOf(cell) + " " + Thread.currentThread()+ " "+ cell.getMousePosition()+" "+ cell.getLocationOnScreen());
//                    //System.out.println(index+ " ---- "+ FieldBuilder.shellList.get(index));
//                    //revalidate();
//                    //jPanel1.repaint();
//                    jPanel1.removeAll();
//                    //FieldBuilder.printList(FieldBuilder.shellList);
//                    for (StandardCell cell : FieldBuilder.shellList) {
//                        jPanel1.add(cell);
//                    }
//                    jPanel1.revalidate();
//                    jPanel1.repaint();
//                }
//
//            });
//        }
//
//        return jPanel1;
//    }
//
//    private JPanel getStartingPage() {
//        startingPanel = new JPanel();
//
//        startButton = new JButton("Start the game!");
//        FlowLayout fl = new FlowLayout();
//        startingPanel.setLayout(fl);
//        startingPanel.add(startButton);
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StandardFrame jf = new StandardFrame();
//                jf.setVisible(true);
//                jf.setContentPane(getContent());
//                jf.setResizable(false);
//
//                jf.pack();
//                
//            }
//        });
//        return startingPanel;
//    }
}
