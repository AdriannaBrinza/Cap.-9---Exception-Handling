package com.itfactory;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Persoana citestePersoana() {
        System.out.print("Introduceti numele complet al persoanei: ");
        String numeComplet = scanner.nextLine();
        long cnp = 0;
        boolean cnpOK = true;

        while (cnpOK) {
            try {
                System.out.print("Introduceti cnp-ul persoanei " + numeComplet + ": ");
                cnp = Long.parseLong(scanner.nextLine());
                String stringCNP = Long.toString(cnp);
                if (stringCNP.length() == 13) {
                    cnpOK = false;
                } else {
                    System.out.println("CNP-ul persoanei trebuie sa fie format exact din 13 cifre!");
                }

            } catch (NumberFormatException e) {
                System.out.println("CNP-ul trebuie sa fie format numai din cifre. Nu sunt acceptate alte caractere!");
            }
        }

        return new Persoana(numeComplet, cnp);
    }

}