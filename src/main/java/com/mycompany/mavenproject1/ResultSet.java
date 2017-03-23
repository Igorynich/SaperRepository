package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSet {

    private String name;

    private final String bombs;
    private final String time;
    private static LinkedList<ResultSet> allSets = null;
    private static ResultSet latest;
    private static File f;

    public ResultSet(String name, String bombs, String time) {
        this.name = name;
        this.bombs = bombs;
        this.time = time;
        //allSets.add(this);
        latest = this;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBombs() {
        return bombs;
    }

    public String getTime() {
        return time;
    }

    public static LinkedList<ResultSet> getAllSets() {
        return allSets;
    }

    public static ResultSet getLatest() {
        return latest;
    }

    public static void sort() {

    }

    public static void readFromFile() {
        allSets = new LinkedList<ResultSet>();
        try {
            f = new File("D:" + File.separator, "saperResults.txt");
            if (f.createNewFile()) {
                System.out.println("Creating FILE while reading..");
                f.createNewFile();
                f.setReadable(true);
                f.setWritable(true);
            } else {
                System.out.println("FILE ALREADY EXISTS");
                Scanner sc = new Scanner(new FileReader(f));
                while (sc.hasNextLine()) {
                    allSets.add(new ResultSet(sc.next(), sc.next(), sc.next()));
                }

            }
        } catch (IOException ex) {
            System.out.println("LOGGER");
            Logger.getLogger(ResultScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeToFile(ResultSet rs) {

        try {
            f = new File("D:" + File.separator, "saperResults.txt");
            if (f.createNewFile()) {
                System.out.println("Creating FILE while writing..");
                f.createNewFile();
                f.setReadable(true);
                f.setWritable(true);
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(f, true))) {
                
                //writer.write(rs.name + " " + rs.bombs + " " + rs.time+"\n");
                writer.println();
                writer.print(rs.name + " " + rs.bombs + " " + rs.time);

            }
        } catch (IOException ex) {
            System.out.println("LOGGER");
            Logger.getLogger(ResultScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
