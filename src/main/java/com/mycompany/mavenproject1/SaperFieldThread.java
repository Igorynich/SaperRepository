/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author User
 */
public class SaperFieldThread implements Runnable {

    JButton startButton = null;
    JPanel startingPanel = null;
    JPanel jPanel1 = null;
    StandardFrame sf = null;
    JLayeredPane layPane = null;
    JOptionPane jOption = null;
    String s = null;
    JSlider diffSlider = null;
    JSpinner newFieldX = null;
    JSpinner newFieldY = null;

    @Override
    public void run() {
        sf = new StandardFrame();
        sf.setVisible(true);
        sf.setTitle("Set your game");
        sf.add(getStartingPage());
        sf.pack();
        //sf.add(getAskNameDialog());
    }

    private JPanel getStartingPage() {
        startingPanel = new JPanel();
        startButton = new JButton("Start the game!");
        startingPanel.setLayout(new BorderLayout());
        startingPanel.add(getDiffSlider(), BorderLayout.NORTH);
        startingPanel.add(startButton, BorderLayout.SOUTH);
        JPanel fieldSize = new JPanel(new FlowLayout());
        startingPanel.add(fieldSize, BorderLayout.CENTER);
        fieldSize.setBorder(BorderFactory.createTitledBorder(
                "Field Size"));
        fieldSize.add(getFieldSizeSpinnerX());
        fieldSize.add(getFieldSizeSpinnerY());
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandardFrame jf = new StandardFrame();
                jf.setVisible(true);
                System.out.println("SIZES: " + StandardBoard.getSize()[0] + " " + StandardBoard.getSize()[1]);
                FieldBuilder.getField();
                jf.add(getContent());
                jf.setTitle("SAPER");

                jf.setResizable(false);

                jf.pack();
                sf.dispose();

            }
        });

        //layPane.add(getDiffSlider(), 1);
        return startingPanel;
    }

    private JOptionPane getAskNameDialog() {
        jOption = new JOptionPane();
        do {
            s = (String) JOptionPane.showInputDialog("Enter your name:");
        } while (s.length() == 0);
        return jOption;

    }

    private JSlider getDiffSlider() {
        diffSlider = new JSlider(JSlider.HORIZONTAL,
                5, 40, StandardBoard.getDifficulty());
        diffSlider.setMajorTickSpacing(5);
        diffSlider.setMinorTickSpacing(1);
        diffSlider.setPaintTicks(true);
        diffSlider.setPaintLabels(true);
        diffSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                int newDiff = (int) source.getValue();
                StandardBoard.setDifficulty(newDiff);
                diffSlider.setBorder(BorderFactory.createTitledBorder(
                        "Difficulty = " + StandardBoard.getDifficulty()));
            }
        });
        diffSlider.setBorder(BorderFactory.createTitledBorder(
                "Difficulty = " + StandardBoard.getDifficulty()));
        return diffSlider;
    }

    private JPanel getContent() {

        jPanel1 = new JPanel();
        GridLayout gl = new GridLayout(StandardBoard.getSize()[0], StandardBoard.getSize()[1], 1, 1);
        jPanel1.setLayout(gl);

        for (StandardCell cell : FieldBuilder.shellList) {
            jPanel1.add(cell);

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

                    //FieldBuilder.printList(FieldBuilder.shellList);
                    //FieldBuilder.printList(FieldBuilder.fieldList);
                    int index = FieldBuilder.shellList.indexOf(cell);
                    if (index != -1) {
                        System.out.println("Clicked Cell N: " + index);
                        System.out.println("CLICKED in shellList: " + index + " " + Thread.currentThread() + " " + cell.getMousePosition() + " " + cell.getLocationOnScreen());
                        System.out.println("Field List Cell: " + index + "  " + FieldBuilder.fieldList.get(index));
                        FieldBuilder.shellList.set(index, FieldBuilder.fieldList.get(index));

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

            });
        }

        return jPanel1;
    }

    private JSpinner getFieldSizeSpinnerX() {
        SpinnerModel model
                = new SpinnerNumberModel(StandardBoard.getSize()[0], //initial value
                        StandardBoard.getSize()[0] - 5, //min
                        StandardBoard.getSize()[0] + 50, //max
                        1);                //step
        newFieldX = new JSpinner(model);

        newFieldX.setBorder(BorderFactory.createTitledBorder(
                "Width = " + StandardBoard.getSize()[0]));

        newFieldX.setPreferredSize(new Dimension(120, 50));
        newFieldX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) newFieldX.getValue();

                StandardBoard.setSize(value, 0);
                newFieldX.setBorder(BorderFactory.createTitledBorder(
                        "Width = " + StandardBoard.getSize()[0]));

            }
        });
        return newFieldX;
    }

    private JSpinner getFieldSizeSpinnerY() {
        SpinnerModel model
                = new SpinnerNumberModel(StandardBoard.getSize()[1], //initial value
                        StandardBoard.getSize()[1] - 5, //min
                        StandardBoard.getSize()[1] + 50, //max
                        1);                //step
        newFieldY = new JSpinner(model);
        newFieldY.setBorder(BorderFactory.createTitledBorder(
                "Heigth = " + StandardBoard.getSize()[1]));
        newFieldY.setPreferredSize(new Dimension(120, 50));
        newFieldY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) newFieldY.getValue();
                StandardBoard.setSize(0, value);
                newFieldY.setBorder(BorderFactory.createTitledBorder(
                        "Heigth = " + StandardBoard.getSize()[1]));

            }
        });
        return newFieldY;
    }
}
