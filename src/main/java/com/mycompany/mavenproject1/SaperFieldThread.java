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
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuListener;

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
    JLabel bombCounter = null;
    JLabel timer = null;
    JButton refresh = null;
    StandardFrame jf = null;
    JPanel base = null;
    Timer tim = null;
    Timer timBomb = null;
    static int time = 0;
    JMenuBar stMenu = null;

    @Override
    public void run() {
        sf = new StandardFrame();
        sf.setVisible(true);
        sf.setTitle("Set your game");
        sf.add(getStartingPage());
        sf.setJMenuBar(getStartingMenu());
        sf.pack();
        //sf.add(getAskNameDialog());
    }

    public static int getTime() {
        return time;
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
                if ((JButton) e.getSource() == startButton) {
                    jf = new StandardFrame();
                    jf.setVisible(true);
                    System.out.println("SIZES: " + StandardBoard.getSize()[0] + " " + StandardBoard.getSize()[1]);
                    FieldBuilder.getField();
                    base = new JPanel(new BorderLayout());
                    jf.add(base);
                    JPanel topPanel = new JPanel(new BorderLayout());
                    topPanel.setBorder(BorderFactory.createTitledBorder("INFO"));
                    base.add(topPanel, BorderLayout.NORTH);
                    topPanel.add(getBombCounter(), BorderLayout.WEST);
                    topPanel.add(getRefreshButton(), BorderLayout.CENTER);
                    topPanel.add(getTimer(), BorderLayout.EAST);
                    base.add(getContent(), BorderLayout.SOUTH);
                    jf.setTitle("SAPER");

                    jf.setResizable(false);
                    jf.setJMenuBar(getFieldMenu());
                    jf.pack();
                    System.out.println(jf);
                    sf.dispose();
                }

            }
        });

        //layPane.add(getDiffSlider(), 1);
        return startingPanel;
    }

    private JMenuBar getStartingMenu() {
        stMenu = null;
        stMenu = new JMenuBar();
        JMenu resMenu = new JMenu("Results");
        stMenu.add(resMenu);
        resMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandardFrame results = new StandardFrame();  //GAME OVER FRAME
                results.setVisible(false);
                new ResultScreen(results, "Game Over Dialog", false);
            }
        });
        resMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                StandardFrame results = new StandardFrame();  //GAME OVER FRAME
                results.setVisible(false);
                new ResultScreen(results, "Game Over Dialog", false);
            }

        });

        return stMenu;
    }

    private JMenuBar getFieldMenu() {
        JMenuBar fMenu = null;
        fMenu = new JMenuBar();
        JMenu resMenu = new JMenu("Results");
        fMenu.add(resMenu);
        resMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                StandardFrame results = new StandardFrame();  //GAME OVER FRAME
                results.setVisible(false);
                new ResultScreen(results, "Game Over Dialog", false);
            }
        });
        JMenu backToStart = new JMenu ("Back to Start");
        fMenu.add(backToStart);
        //backToStart.setMnemonic(KeyEvent.VK_BACK_SPACE);
        backToStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                jf.dispose();
                java.awt.EventQueue.invokeLater(new SaperFieldThread());
            }
            
});
        
        return fMenu;
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
        jPanel1 = null;
        jPanel1 = new JPanel();
        GridLayout gl = new GridLayout(StandardBoard.getSize()[0], StandardBoard.getSize()[1], 1, 1);
        jPanel1.setLayout(gl);

        for (StandardCell cell : FieldBuilder.shellList) {
            jPanel1.add(cell);
            cell.addMouseListener(new SaperMouseAdapter(jPanel1, cell, tim));
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

    private JLabel getBombCounter() {

        bombCounter = new JLabel((FieldBuilder.getBombCounter() - FieldBuilder.getQuestionCounter()) + "/" + FieldBuilder.getBombCounter());
        bombCounter.setBorder(BorderFactory.createTitledBorder("BOMBS LEFT:"));
        bombCounter.setPreferredSize(new Dimension(110, 40));
        timBomb = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bombCounter.setText((FieldBuilder.getBombCounter() - FieldBuilder.getQuestionCounter()) + "/" + FieldBuilder.getBombCounter());
                timer.revalidate();
                timer.repaint();
            }
        });
        timBomb.setRepeats(true);
        timBomb.setCoalesce(true);
        timBomb.start();
        return bombCounter;
    }

    private JLabel getTimer() {

        //timer = null;
        Calendar cal = null;
        timer = new JLabel();
        cal = Calendar.getInstance();
        long start = cal.getTimeInMillis();
//        int mins = cal.get(Calendar.MINUTE);
//        int secs = cal.get(Calendar.SECOND);
        tim = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar cal1 = Calendar.getInstance();
                long end = cal1.getTimeInMillis();
//                int difMin = cal1.get(Calendar.MINUTE) - mins;
//                int difSec = cal1.get(Calendar.SECOND) - secs;
//                int res = difMin * 60 + difSec;
                long res = (end - start) / 1000;
                time = (int) res;
                timer.setText(String.valueOf(res));
                timer.revalidate();
                timer.repaint();
            }
        });
        tim.setRepeats(true);
        tim.setCoalesce(true);
        tim.start();

        timer.setPreferredSize(new Dimension(70, 40));
        timer.setBorder(BorderFactory.createTitledBorder("Timer"));
        return timer;
    }

    private JButton getRefreshButton() {
        refresh = new JButton("R");
        refresh.setPreferredSize(new Dimension(50, 40));
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((JButton) e.getSource() == refresh) {

                    System.out.println("----------NEW GAME----------");

                    //StandardFrame jf1 = new StandardFrame();
                    jf.setVisible(true);
                    System.out.println("SIZES: " + StandardBoard.getSize()[0] + " " + StandardBoard.getSize()[1]);
                    FieldBuilder.getField();
                    base.removeAll();

                    JPanel topPanel = new JPanel(new BorderLayout());
                    topPanel.setBorder(BorderFactory.createTitledBorder("INFO"));
                    base.add(topPanel, BorderLayout.NORTH);
                    timBomb.stop();
                    topPanel.add(getBombCounter(), BorderLayout.WEST);
                    topPanel.add(getRefreshButton(), BorderLayout.CENTER);
                    tim.stop();
                    topPanel.add(getTimer(), BorderLayout.EAST);

                    base.add(getContent(), BorderLayout.SOUTH);
                    base.revalidate();
                    base.repaint();
                    jf.setTitle("SAPER");

                    jf.setResizable(false);

                    jf.pack();
                }
            }
        });
        return refresh;
    }
}
