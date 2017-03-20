/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

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
import javax.swing.JTextField;
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

    @Override
    public void run() {
        sf = new StandardFrame();
        sf.setVisible(true);
        sf.add(getStartingPage());
        sf.pack();
        sf.add(getAskNameDialog());
    }

    private JLayeredPane getStartingPage() {
        startingPanel = new JPanel();
        layPane = new JLayeredPane();

        layPane.setBorder(BorderFactory.createTitledBorder(
                "LayPane"));
        FlowLayout fl = new FlowLayout();
        layPane.setLayout(fl);
        startButton = new JButton("Start the game!");
        layPane.add(startingPanel, 1);
        startingPanel.setLayout(fl);
        startingPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandardFrame jf = new StandardFrame();
                jf.setVisible(true);
                jf.add(getContent());
                
                jf.setResizable(false);

                jf.pack();
                sf.dispose();

            }
        });
        
        layPane.add(getDiffSlider(), 1);
        return layPane;
    }
    private JOptionPane getAskNameDialog (){
        jOption = new JOptionPane();
        do {
            s = (String) JOptionPane.showInputDialog("Enter your name:");
        } while (s.length() == 0);
        return jOption;

    }

    private JSlider getDiffSlider() {
        diffSlider = new JSlider(JSlider.HORIZONTAL,
                5, 40, StandardBoard.getDifficulty());
        diffSlider.setMajorTickSpacing(10);
        diffSlider.setMinorTickSpacing(1);
        diffSlider.setPaintTicks(true);
        diffSlider.setPaintLabels(true);
        diffSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int newDiff = (int)source.getValue();
                StandardBoard.setDifficulty(newDiff);
                diffSlider.setBorder(BorderFactory.createTitledBorder(
                "Difficulty = "+StandardBoard.getDifficulty()));
            }
        });
        diffSlider.setBorder(BorderFactory.createTitledBorder(
                "Difficulty = "+StandardBoard.getDifficulty()));
        return diffSlider;
    }

    private JPanel getContent() {

        jPanel1 = new JPanel();
        GridLayout gl = new GridLayout(StandardBoard.size[0], StandardBoard.size[1]);
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

}
