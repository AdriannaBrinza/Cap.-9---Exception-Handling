package com.itfactory.exercitiiExceptii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        // Wait for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }
        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
        writeToFile();
    }
    public void run() {
        amount++;
    }

    public static void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"))) {
            bw.write("Test");
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            e.toString();
        }
    }
}