package com.itfactory.exercitiiExceptii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        try {
            int a[] = new int[2];
            a[0] = 1;
            a[1] = 3;
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
            e.printStackTrace();
            e.getCause();
        }
        System.out.println("Out of the block");

    }
}
