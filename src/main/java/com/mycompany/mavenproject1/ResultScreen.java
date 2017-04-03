package com.mycompany.mavenproject1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ResultScreen extends JDialog {

    JPanel base = null;
    JLabel lab = null;
    JTextField txt = null;
    LinkedList<String> results = null;
    Vector<String> resVector = null;
    Vector<String> columns = new Vector<String>();
    Dimension d = new Dimension();
    File f;
    JTable table = null;
    String str = "user";
    ResultSet winner;
    boolean pressed = false;

    public ResultScreen(Frame owner, String title, boolean win) {
        super(owner, title);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(owner);
        //this.setModalityType(ModalityType.APPLICATION_MODAL);
        if (win) {
            getWinnerResultScreen();
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                    if (!pressed) {
                        winner = new ResultSet(str, String.valueOf(FieldBuilder.getBombCounter()), String.valueOf(SaperFieldThread.getTime()));
                        ResultSet.writeToFile(winner);
                    }
                }

            });
        } else {
            getLoserResultScreen();
        }
        this.pack();

    }

    private void getLoserResultScreen() {
        //base = new JPanel(new GridLayout(0, 4));
        base = new JPanel(new BorderLayout());
        this.add(base);
        JPanel top = new JPanel(new GridLayout(1, 4));
        base.add(top, BorderLayout.NORTH);
        //System.out.println("FILE EXISTS " + f.exists());
        top.add(getLabel("Place"));
        //columns.add("Place");
        top.add(getLabel("Name"));
        //columns.add("Name");
        top.add(getLabel("Bombs"));
        //columns.add("Bombs");
        top.add(getLabel("Time"));
        JPanel left = new JPanel(new GridLayout(0, 4));
        base.add(left, BorderLayout.CENTER);
        left.setBorder(BorderFactory.createTitledBorder("Results:"));
        int i = 1;
        ResultSet.readFromFile();

        for (ResultSet rs : ResultSet.getAllSets()) {
            if ((i < 10) && (i <= ResultSet.getAllSets().size())) {
                left.add(getLabel(String.valueOf(i)));
                left.add(getLabel(rs.getName()));
                left.add(getLabel(rs.getBombs()));
                left.add(getLabel(rs.getTime()));
                i++;
            }
        }
        d.setSize(200, i * 40);
        this.setPreferredSize(d);
        //columns.add("Time");
        //base.add(getResultsTable());

//        for (String s : readResultsFile()) {
//            System.out.println("ADDING LABEL");
//            base.add(getLabel(s));
//        }
    }

    private void getWinnerResultScreen() {
        //base = new JPanel(new GridLayout(0, 4));
        base = new JPanel(new BorderLayout());
        this.add(base);
        JPanel top = new JPanel(new GridLayout(1, 4));
        base.add(top, BorderLayout.NORTH);
        //System.out.println("FILE EXISTS " + f.exists());
        top.add(getLabel("Place"));
        //columns.add("Place");
        top.add(getLabel("Name"));
        //columns.add("Name");
        top.add(getLabel("Bombs"));
        //columns.add("Bombs");
        top.add(getLabel("Time"));
        JPanel left = new JPanel(new GridLayout(0, 4));
        base.add(left, BorderLayout.CENTER);
        left.setBorder(BorderFactory.createTitledBorder("Results:"));
        int i = 1;
        ResultSet.readFromFile();

        for (ResultSet rs : ResultSet.getAllSets()) {
            if ((i < 10) && (i < ResultSet.getAllSets().size())) {
                left.add(getLabel(String.valueOf(i)));
                left.add(getLabel(rs.getName()));
                left.add(getLabel(rs.getBombs()));
                left.add(getLabel(rs.getTime()));
                i++;
            }
        }
        left.add(getLabel(String.valueOf(i)));
        left.add(getTextField());

        System.out.println("STRING: " + str);
        //System.out.println("STRING winner: " + winner.getName());
        left.add(getLabel(String.valueOf(FieldBuilder.getBombCounter())));
        left.add(getLabel(String.valueOf(SaperFieldThread.getTime())));
        i++;

        d.setSize(250, i * 40);
        this.setPreferredSize(d);

    }

    private JLabel getLabel(String s) {
        lab = new JLabel(s);

        return lab;
    }

    private JTextField getTextField() {
        txt = new JTextField(30);
        txt.setText(str);
        pressed = false;
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!pressed) {
                        str = txt.getText();
                        //winner.setName(str);
                        //System.out.println("STRING winner enter: " + winner.getName());
                        //txt.setText(str);
                        winner = new ResultSet(str, String.valueOf(FieldBuilder.getBombCounter()), String.valueOf(SaperFieldThread.getTime()));
                        ResultSet.writeToFile(winner);
                        txt.setEditable(false);
                        pressed = true;
                    }
                }
            }

        });

        txt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ACTION PERFORMED IN TEXTFIELD");
//                str = txt.getText();
//                winner.setName(str);
//                txt.setEditable(false);
            }
        });
        return txt;
    }

//    private JTable getResultsTable(){
//        resVector = new Vector<>(readResultsFile());
//        table = new JTable(resVector, columns);
//        return table;
//    }
//    private void createResultFile() {
//        try {
//            f = new File("D:" + File.separator, "saperResults.txt");
//            //f.mkdirs();
//            if (f.createNewFile()) {
//                System.out.println("Creating FILE..");
//
//                f.createNewFile();
//                f.setReadable(true);
//            } else {
//                System.out.println("FILE ALREADY EXISTS");
//            }
//            //f = new File("/", "saperResults.txt");
//        } catch (IOException ex) {
//            System.out.println("LOGGER");
//            Logger.getLogger(ResultScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private LinkedList<String> readResultsFile() {
//
//
//        results = new LinkedList<String>();
//        
//        try (Scanner sc = new Scanner(new FileReader(f))) {
//            System.out.println("HALOU");
//            while (sc.hasNext()) {
//                
//                results.add(sc.next());
//                System.out.println("Results: "+ results.toString());
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ResultScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return results;
//    }
}
