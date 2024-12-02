package hu.szamalk.model;

//A konstruktor paramétere kap egy karaktert (ezzel fog rajzolni), saját névvel dolgozva, tehát egy O betűt kell
// kirajzolnia

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Nev {
    //adattagok
    private String karakter;
    private String[][] tomb = new String[3][4];
    //konstruktor
    public Nev(String karakter) {
        this.karakter = karakter;
    }
    //tagfgv-k
    public void feltolt(){

//        String s = String.valueOf(this.name.charAt(0));
//        System.out.println(s);
//        ####
//        #  #
//        ####

        for (int i = 0; i < this.tomb.length; i++) {
            for (int j = 0; j < this.tomb[i].length; j++) {
                if ((i == 1 & j == 1) || (i == 1 & j == 2)) {
                    this.tomb[i][j] = " ";
                } else {
                    this.tomb[i][j] = this.karakter;
                }
            }
        }
    }

    public String kirajzol(){
        String s = "";
        for (int i = 0; i < this.tomb.length; i++) {
            for (int j = 0; j < this.tomb[i].length; j++) {
                    s += this.tomb[i][j];
            }
            s += "\n";
        }
        return s;
    }

    public int karakterekSorban(int sor) {
        if (sor < 0 || sor >= tomb.length) {
            System.out.println("Érvénytelen sor index");
            return -1;
        } else {
            //megszámolja hogy az adott sorban hány karakteres mező van.
            int szamlalo = 0;
            for (int i = 0; i < tomb[sor].length; i++) {
                if (!(tomb[sor][i].equals(" "))) {
                    szamlalo += 1;
                }
            }
            return szamlalo;
        }
    }

    public int karakterekOszlopban(int oszlop) {
        if (oszlop < 0 || oszlop >= tomb[0].length) {
            System.out.println("Érvénytelen oszlop index");
            return -1;
        } else {
            int szamlalo = 0;
            for (int i = 0; i < tomb.length; i++) {
                if (!(tomb[i][oszlop].equals(" "))) {
                    szamlalo += 1;
                }
            }
            return szamlalo;
        }
    }

    public boolean teliSor(int sor){
        int eredmeny = this.karakterekSorban(sor);
        return eredmeny == tomb[sor].length;
    }

    public int teliSorMenny(){
        int szamlalo = 0;
        for (int i = 0; i <  tomb.length; i++) {
            int eredmeny = this.karakterekSorban(i);
            if(eredmeny == tomb[i].length){
                szamlalo +=1;
            }
        }
        return szamlalo;
    }

    public void fajlbaIras() throws IOException {
        String s = this.kirajzol();
        String eleresiUtvonal = "C:\\Users\\both.orsolya\\Desktop\\fajlbairas.txt";
        try(BufferedWriter iras = new BufferedWriter(new FileWriter(eleresiUtvonal))){
            for (int db = 0; db < 100; db++) {
                iras.write(s);
                iras.newLine();
            }
        }
    }
}

