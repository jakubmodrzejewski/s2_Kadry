package com.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Kadry kadry1 = new Kadry();
        //kadry1.dodajPracownikaInteraktywnie();
        kadry1.imprtujZPlikuTekstowego("pracownicy.txt");
        //System.out.println(kadry1);
        System.out.println("Srednie wynagrodzenie w firmie wynosi: " + kadry1.sredniZarobek()+" PLN");
        System.out.println("Srednie wynagrodzenie w dizale 4 wynosi: "+kadry1.sredniZarobek(4)+ " PLN");
        System.out.println(Arrays.toString(kadry1.dajDzialy()));
        kadry1.pisz();
    }
}