package com.itfactory;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Servicii servicii = new Servicii(new ArrayList<>());
        servicii.getListaPersoane().add(new Persoana("Popescu Ion", 184L));
        servicii.getListaPersoane().add(new Persoana("Georgescu Ilinca", 2840411235689L));
        servicii.getListaPersoane().add(new Persoana("Marinescu Ivan", 1840811235689L));
        Persoana persoana1 = Utils.citestePersoana();

        System.out.println("---------primul bloc try-catch:   -------------");
        try {
            servicii.existaCnp(2841201180941L);
        } catch (ExceptiaMea e) {
            e.printStackTrace();
        }

        System.out.println("-----------al doilea bloc try-catch:  ----------");
        try{
            servicii.adaugaPersoana(persoana1);
            servicii.adaugaPersoana(new Persoana("Popescu Ion", 184L));
            servicii.adaugaPersoana(new Persoana("Popescu Ion", 185L));
        } catch (ExceptiaMea e) {
            e.printStackTrace();
        }

        System.out.println("\nLista de persoane este urmatoarea: \n" + servicii.getListaPersoane());
    }
}
