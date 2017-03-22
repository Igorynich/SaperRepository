/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class SaperMouseAdapter extends MouseAdapter {

    StandardCell cell = null;
    JPanel jPanel1 = null;

    public SaperMouseAdapter(JPanel jp, StandardCell sc) {
        cell = sc;
        jPanel1 = jp;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(" Pressed " + e.getClickCount());
        //FieldBuilder.printList(FieldBuilder.shellList);
        //FieldBuilder.printList(FieldBuilder.fieldList);
        System.out.println(" Clicked " + e.getClickCount());
        int index = FieldBuilder.shellList.indexOf(cell);
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (index != -1) {
//                System.out.println("Clicked Cell N: " + index);
                System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
                System.out.println("StandardBoard sizes: " + StandardBoard.getSize()[0]+ " "+ StandardBoard.getSize()[1]);
                FieldBuilder.shellList.set(index, FieldBuilder.fieldList.get(index));
//                System.out.println("Field LIST SIZE " + FieldBuilder.fieldList.size());

            } else {
                System.out.println("FUCCC on Left Click");
            }
            
            if (FieldBuilder.shellList.get(index).getCell() == StandardCell.cellType.HIDDEN) {
                FieldBuilder.fieldList.set(index, new StandardCell(0, 0, StandardCell.cellType.HIDDEN_CHECKED));
                FieldBuilder.checkNear(index);
            }
            
            jPanel1.removeAll();
            for (StandardCell cell : FieldBuilder.shellList) {
                jPanel1.add(cell);
                //cell.addMouseListener(new SaperMouseAdapter(jPanel1, cell));
            }
            jPanel1.revalidate();
            jPanel1.repaint();

        } else {
            System.out.println("Index = " + index);
            if (FieldBuilder.shellList.get(index).getCell() == StandardCell.cellType.SHELL) {
                if (index != -1) {
//                    System.out.println("Clicked Cell N: " + index);
                    System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                    System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                    FieldBuilder.shellList.set(index, new StandardCell(0, 0, StandardCell.cellType.QUESTION));
                    FieldBuilder.shellList.get(index).addMouseListener(new SaperMouseAdapter(jPanel1, FieldBuilder.shellList.get(index)));
                    //System.out.println("Click N: " + e.getClickCount());

                } else {
                    System.out.println("FUCCCCC in SHELL->QUESTION");
                }

                jPanel1.removeAll();

                for (StandardCell cell : FieldBuilder.shellList) {
                    jPanel1.add(cell);

                }
                jPanel1.revalidate();
                jPanel1.repaint();

            } else if (FieldBuilder.shellList.get(index).getCell() == StandardCell.cellType.QUESTION) {
                if (index != -1) {
//                    System.out.println("Clicked Cell N: " + index);
                    System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                    System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                    FieldBuilder.shellList.set(index, new StandardCell(0, 0, StandardCell.cellType.SHELL));
                    FieldBuilder.shellList.get(index).addMouseListener(new SaperMouseAdapter(jPanel1, FieldBuilder.shellList.get(index)));
                    //System.out.println("Click N: " + e.getClickCount());

                } else {
                    System.out.println("FUCCCCC");
                }

                jPanel1.removeAll();

                for (StandardCell cell : FieldBuilder.shellList) {
                    jPanel1.add(cell);

                }
                jPanel1.revalidate();
                jPanel1.repaint();

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //FieldBuilder.printList(FieldBuilder.shellList);
        //FieldBuilder.printList(FieldBuilder.fieldList);
        System.out.println(" Clicked " + e.getClickCount());
        int index = FieldBuilder.shellList.indexOf(cell);
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (index != -1) {
//                System.out.println("Clicked Cell N: " + index);
//                System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                FieldBuilder.shellList.set(index, FieldBuilder.fieldList.get(index));

            } else {
                System.out.println("FUCCC on Left Click");
            }

            jPanel1.removeAll();

            for (StandardCell cell : FieldBuilder.shellList) {
                jPanel1.add(cell);
                //cell.addMouseListener(new SaperMouseAdapter(jPanel1, cell));
            }
            jPanel1.revalidate();
            jPanel1.repaint();
        } else {
            System.out.println("Index = " + index);
            if (FieldBuilder.shellList.get(index).getCell() == StandardCell.cellType.SHELL) {
                if (index != -1) {
//                    System.out.println("Clicked Cell N: " + index);
//                    System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                    System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                    FieldBuilder.shellList.set(index, new StandardCell(0, 0, StandardCell.cellType.QUESTION));
                    FieldBuilder.shellList.get(index).addMouseListener(new SaperMouseAdapter(jPanel1, FieldBuilder.shellList.get(index)));
                    //System.out.println("Click N: " + e.getClickCount());

                } else {
                    System.out.println("FUCCCCC in SHELL->QUESTION");
                }

                jPanel1.removeAll();

                for (StandardCell cell : FieldBuilder.shellList) {
                    jPanel1.add(cell);

                }
                jPanel1.revalidate();
                jPanel1.repaint();

            } else if (FieldBuilder.shellList.get(index).getCell() == StandardCell.cellType.QUESTION) {
                if (index != -1) {
//                    System.out.println("Clicked Cell N: " + index);
                    //System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
//                    System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                    FieldBuilder.shellList.set(index, new StandardCell(0, 0, StandardCell.cellType.SHELL));
                    FieldBuilder.shellList.get(index).addMouseListener(new SaperMouseAdapter(jPanel1, FieldBuilder.shellList.get(index)));
                    //System.out.println("Click N: " + e.getClickCount());

                } else {
                    System.out.println("FUCCCCC");
                }

                jPanel1.removeAll();

                for (StandardCell cell : FieldBuilder.shellList) {
                    jPanel1.add(cell);

                }
                jPanel1.revalidate();
                jPanel1.repaint();

            }
        }

    }

}
