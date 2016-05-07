package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kuba on 2016-04-04.
 */
public class Kadry implements Serializable {
    private Pracownik[] pracownicy;
    private Integer zatrudnienie;

    public Kadry() {
        pracownicy = new Pracownik[100];
        zatrudnienie = 0;
    }

    private void dodajPracownika(Pracownik pracownik) {
        if (zatrudnienie < 100) {
            pracownicy[zatrudnienie] = pracownik;
            zatrudnienie++;
        } else
            System.out.println("Nie mozna dodac pracownika, osiagnieto limit pracownikow w firmie.");

    }

    public void dodajPracownikaInteraktywnie() {
        System.out.println("Wprowadzanie danych nowego pracownika.");
        Scanner odczyt = new Scanner(System.in);
        String imie;
        String nazwisko;
        double placa;
        int dzial;
        System.out.println("Podaj imie nowego pracownika.");
        imie = odczyt.nextLine();
        System.out.println("Podaj nazwisko nowego pracownika.");
        nazwisko = odczyt.nextLine();
        System.out.println("Podaj plec nowego pracownika (M/K).");
        String temp = odczyt.nextLine();
        System.out.println("Podaj wielkosc zarobkow nowego pracownika.");
        placa = odczyt.nextDouble();
        System.out.println("Podaj dzial w ktorym pracowac bedzie nowy pracownik.");
        dzial = odczyt.nextInt();
        char[] mojZnak = temp.toCharArray();
        Pracownik pracownik = new Pracownik(imie, nazwisko, placa, mojZnak[0], dzial);
        dodajPracownika(pracownik);
        odczyt.close();
    }

    public void imprtujZPlikuTekstowego(String nazwaPliku) throws FileNotFoundException {
        String[] danePracownika = new String[100];
        Scanner scanner = new Scanner(new File(nazwaPliku)).useDelimiter("/n/r");

        while (scanner.hasNext()) {
            Scanner czytaj = new Scanner(scanner.nextLine());
            for (int i = 0; i < 5; i++) {
                danePracownika[i] = czytaj.next();
            }
            char znak;
            char[] myChar;
            myChar = danePracownika[3].toCharArray();
            znak = myChar[0];
            Pracownik pracownik = new Pracownik(danePracownika[0], danePracownika[1], Double.valueOf(danePracownika[2]),
                    znak, Integer.valueOf(danePracownika[4]));
            dodajPracownika(pracownik);
            czytaj.close();
        }
        scanner.close();
        System.out.println("Prawidlowo dokonano importu pracownikow z pliku.");


    }

    protected double sredniZarobek() {
        double wynik = 0;
        for (int i = 0; i < zatrudnienie; i++)
            wynik = wynik + pracownicy[i].czytajPlaca();
        return wynik / zatrudnienie;

    }

    protected double sredniZarobek(int dzial) {
        double wynik = 0;
        int ilosc = 0;
        for (int i = 0; i < zatrudnienie; i++) {
            if (pracownicy[i].czytajDzial() == dzial) {
                wynik = wynik + pracownicy[i].czytajPlaca();
                ilosc++;
            }
        }
        return wynik / ilosc;
    }

    protected int[] dajDzialy() {
        int[] Tablica = new int[zatrudnienie];
        int licznik = 0;
        boolean jest;
        for (int i = 0; i < zatrudnienie; i++) {
            jest = false;
            for (int j = 0; j < licznik; j++) {
                if (jest == false) {
                    if (Tablica[j] == pracownicy[i].czytajDzial()) {
                        jest = true;
                    } else {
                        jest = false;
                    }
                }
            }
            if (jest == false) {
                Tablica[licznik] = pracownicy[i].czytajDzial();
                licznik++;
            }
        }
        int[] nowatablica = new int[licznik];
        for (int j = 0; j < licznik; j++) {
            nowatablica[j] = Tablica[j];
        }
        return nowatablica;
    }

    public void pisz() {
        System.out.println(this);
        System.out.println("Srednie Wynagrodzenie w firmie wynosi: " + this.sredniZarobek() + " zl.");
        for (int i = 0; i < this.dajDzialy().length; i++) {
            System.out.printf("Srednie wynagrodzenie w dziale " + this.dajDzialy()[i] + " wynosi: " + sredniZarobek(this.dajDzialy()[i]) + "." + '\n');
        }
    }

    @Override
    public String toString() {
        String tekst= "Kadry{";
        for (int i = 0; i < zatrudnienie; i++) {
            tekst = tekst + pracownicy[i].toString();
        }
        return tekst;
    }
}
