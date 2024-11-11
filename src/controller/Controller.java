package controller;

import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    // En metode til at oprette en ny forestilling
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling); // Gemmer forestillingen i Storage
        return forestilling;
    }

    // En metode til at oprette en ny kunde
    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde); // Gemmer kunden i Storage
        return kunde;
    }

    // En metode til at oprette en ny plads
    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads); // Gemmer pladsen i Storage
        return plads;
    }
}
