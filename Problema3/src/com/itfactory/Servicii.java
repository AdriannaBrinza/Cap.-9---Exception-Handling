package com.itfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servicii {
    private List<Persoana> listaPersoane;

    public Servicii(List<Persoana> listaPersoane) {
        this.listaPersoane = listaPersoane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicii servicii = (Servicii) o;
        return Objects.equals(listaPersoane, servicii.listaPersoane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaPersoane);
    }

    @Override
    public String toString() {
        return "Servicii{" +
                "listaPersoane=" + listaPersoane +
                '}';
    }

    public List<Persoana> getListaPersoane() {
        return listaPersoane;
    }

    public void existaCnp(long cnp) throws ExceptiaMea {
        boolean cnpGasit = false;
        for (Persoana persoana : listaPersoane) {
            if (persoana.getCnp() == cnp) {
                System.out.println("Persoana cu CNP " + cnp + " exista. Numele ei este: " + persoana.getNumeComplet());
                cnpGasit = true;
                break;
            }
        }
        if (!cnpGasit) {
            throw new ExceptiaMea("\nPersoana cu CNP " + cnp + " nu exista in lista.");
        }
    }

    public boolean existaCNP(long cnp) {
        for (Persoana persoana : listaPersoane) {
            if (persoana.getCnp() == cnp) {
                return true;
            }
        }
        return false;
    }


    public void adaugaPersoana(Persoana persoanaCautata) throws ExceptiaMea {
        if (listaPersoane.contains(persoanaCautata)) {
            throw new ExceptiaMea("Persoana" + persoanaCautata + " exista in lista");
        } else if (existaCNP(persoanaCautata.getCnp())) {
            throw new ExceptiaMea("O persoana cu acest CNP " + persoanaCautata.getCnp() + " exista deja in lista. Nu pot exista 2 persoane cu acelasi CNP.");
        } else {
            System.out.println("Persoana " + persoanaCautata + " nu a fost gasita in lista. Va fi adaugata.");
            listaPersoane.add(persoanaCautata);
        }
    }

}