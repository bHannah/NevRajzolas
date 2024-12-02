package hu.szamalk;

import hu.szamalk.model.Nev;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    Nev nev = new Nev("#");
    nev.feltolt();
    System.out.println("A betű kirajzolása:");
    nev.kirajzol();
    System.out.println("A második sorban levő karakterek mennyisége:");
    System.out.println(nev.karakterekSorban(1));
    System.out.println("Az első oszlopban levő karakterek mennyisége:");
    System.out.println(nev.karakterekOszlopban(0));
    System.out.println("A harmadik sor teli sor-e?:");
    System.out.println(nev.teliSor(2));
    System.out.println("Hány db teli sor van?:");
    System.out.println(nev.teliSorMenny());
    nev.fajlbaIras();
    }
}