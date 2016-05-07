package com.company;

/**
 * Created by Kuba on 2016-04-04.
 */
public class Pracownik {
    private String imie;
    private String nazwisko;
    private Double placa;
    private Character plec;
    private Integer dzial;

    public Pracownik(String imie, String nazwisko, Double placa, Character plec, Integer dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    public boolean czyPracujeWDziale(Pracownik pracownik, Integer dzial) {
        if (pracownik.dzial == dzial) return true;
        else return false;

    }

    @Override
    public String toString() {
        return ("Pracownik:\n\n" +
                "Imie " + imie + '\n' +
                "Nazwisko " + nazwisko + '\n' +
                "Placa " + placa + '\n' +
                "Plec " + plec + '\n' +
                "Dzial " + dzial + '\n');
    }

    public int czytajDzial() {
        return dzial;
    }

    public double czytajPlaca() {

        return placa;
    }

}
