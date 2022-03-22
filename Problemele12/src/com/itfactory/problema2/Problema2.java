package com.itfactory.problema2;

import java.util.Arrays;
import java.util.Scanner;

public class Problema2 {
    public static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        printOptions();
        while (true) {
            System.out.print("\nAlegeti o optiune din cele 2 disponibile ale aplicatiei: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0: {
                    System.out.println("Ati selectat sa iesiti din aplicatie. La revedere!");
                    System.exit(0);
                }
                break;
                case 1: {
                    try {
                        int[] myArray = citesteElementeArray();
                        verificaOrdineArray(myArray);
                    } catch (ExceptieArray e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Elementele array-ului trebuie sa fie valori numerice si nu alte caractere sau null.");
                    }
                }
                break;
                default: {
                    System.out.println("Aceasta optiune nu exista.");
                }
            }
        }

    }

    static void printOptions() {
        System.out.println("Optiuni disponibile: \n" +
                "0 - Parasiti aplicatia\n" +
                "1 - Verificati daca elementele unui array sunt ordonate crescator");
    }

    static void verificaOrdineArray(int[] myArray) throws ExceptieArray {
        int contor = 0;
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] < myArray[i - 1]) {
                throw new ExceptieArray("\nElementele din acest array " + Arrays.toString(myArray) + " nu sunt ordonate crescator.");
            } else {
                contor++;
            }
        }
        if (contor == (myArray.length - 1)) {
            System.out.println("\nElementele din acest array " + Arrays.toString(myArray) + " sunt ordonate crescator.");
        }
    }


    static int[] citesteElementeArray() {
        System.out.print("\nUrmeaza sa verificam daca elementele unui array, citite de la tastatura, sunt ordonate crescator. \n" +
                "Pentru inceput, precizati care va fi lungimea array-ului: ");
        int lungime = Integer.parseInt(scanner.nextLine());
        int[] myArray = new int[lungime];
        System.out.println("\nAcum urmeaza sa introduceti cate o valoare pentru fiecare element al array-ului.");
        for (int i = 0; i < myArray.length; i++) {
            boolean checkIfNumber = true;
            while (checkIfNumber) {
                try {
                    System.out.print("Elementul " + i + ": ");
                    myArray[i] = Integer.parseInt(scanner.nextLine());
                    checkIfNumber = false;
                } catch (NumberFormatException e) {
                    System.out.println("Trebuie introdusa o valoare numerica");
                }
            }
        }
        return myArray;
    }


    static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}

/*Sa se creeze un program simplu in care se va crea o metoda (in acceeasi clasa cu metoda main).
Metoda va primi ca parametru un array de numere (int).
Daca numerele din array nu sunt in ordine consecutiva se va arunca o exceptie.
Exemplu:
{5,6,7,8} - nu va arunca exceptie.
{5,6,9,8} - va arunca exceptie. */