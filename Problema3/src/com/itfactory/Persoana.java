package com.itfactory;

import java.util.Objects;

public class Persoana {
    private String numeComplet;
    private long cnp;

    public Persoana(String numeComplet, long cnp) {
        this.numeComplet = numeComplet;
        this.cnp = cnp;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public long getCnp() {
        return cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return cnp == persoana.cnp && Objects.equals(numeComplet, persoana.numeComplet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeComplet, cnp);
    }

    @Override
    public String toString() {
        return "{" + numeComplet + ", " + cnp + "}";
    }

}