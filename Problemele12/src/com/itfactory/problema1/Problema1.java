package com.itfactory.problema1;

import java.util.*;

public class Problema1 {
    public static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        List<String> listaCuvintePermise = new ArrayList<>();
        printMenu();
        while (true) {
            parseOptions(listaCuvintePermise);
        }
    }

    static String citesteCuvinte(List<String> listaCuvintePermise) throws ExceptiaMea {
        Set<String> setCuvinteNepermise = new HashSet<>();
        setCuvinteNepermise.add("pupaza");
        setCuvinteNepermise.add("pruna");

        System.out.print("Introduceti un cuvant: ");
        String cuvant = scanner.nextLine();
        if (setCuvinteNepermise.contains(cuvant.toLowerCase())) {
            throw new ExceptiaMea("Ati introdus un cuvant nepermis!");
        } else if (cuvant.isEmpty()) {
            throw new ExceptiaMea("Ati introdus un text gol");
        } else {
            System.out.println("Ati adaugat cuvantul: " + cuvant);
            listaCuvintePermise.add(cuvant);
            return cuvant;
        }
    }

    static void afiseazaCuvintePermise(List<String> listaCuvintePermise) {
        for (String cuvant : listaCuvintePermise) {
            System.out.println(cuvant);
        }
    }

    static void printMenu() {
        System.out.println("Optiuni disponibile:\n" +
                "0 - Parasiti aplicatia\n" +
                "1 - Introduceti un cuvant de la tastatura\n" +
                "2 - Afisati lista cuvintelor introduse\n" +
                "3 - Afisati meniul principal");
    }

    static void parseOptions(List<String> listaCuvintePermise) {
        System.out.print("\nAlegeti una din optiunile disponibile: ");
        try {
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0: {
                    System.out.println("Ati ales sa iesiti din aplicatie. La revedere!");
                    System.exit(0);
                }
                break;
                case 1: {
                    try {
                        citesteCuvinte(listaCuvintePermise);
                    } catch (ExceptiaMea e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 2: {
                    System.out.println("Lista cuvintelor introduse: ");
                    afiseazaCuvintePermise(listaCuvintePermise);
                }
                break;
                case 3: {
                    printMenu();
                }
                break;
                default: {
                    System.out.println("Aceasta optiune nu exista.");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Atentie! Trebuie sa introduceti o valoare numerica!");
        }
    }

}

/* Sa se creeze un program in care se va crea o metoda in aceeasi clasa cu metoda main, care citeste cuvinte de la tastatura pana la introducerea
unui anume cuvant.
Daca cuvantul respectiv contine cuvinte precum ("pruna" sau "pupaza") se va arunca o exceptie. (Exceptia trebuie creata de voi).
(Mai pe scurt simulam un mic programel in care prevenim cuvintele vulgare)  */
