package gui;

import controller.Controller;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;

import java.time.LocalDate;

public class AppInitializer {

    public static void main(String[] args) {
        initStorage();
        testPrint();
    }

    // Initialiserer og gemmer data i Storage
    public static void initStorage() {
        // Oprettelse af forestillinger
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        // Oprettelse af kunder
        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

        // Oprettelse af pladser med priser og placering
        for (int række = 1; række <= 15; række++) {
            for (int nr = 1; nr <= 20; nr++) {
                PladsType pladsType;
                int pris;

                if (række <= 10 && (nr == 9 || nr == 10 || nr == 11 || nr == 12 || nr == 13 || nr == 14)) {
                    // Ekstra benplads
                    pladsType = PladsType.EKSTRABEN;
                    pris = 450;
                } else if ((række == 10 || række == 11) && (nr == 9 || nr == 10 || nr == 11 || nr == 12)) {
                    // Plads til kørestol
                    pladsType = PladsType.KØRESTOL;
                    pris = 450;
                } else if (række <= 5 || række >= 12) {
                    // Blå pladser (400 kr)
                    pladsType = PladsType.STANDARD;
                    pris = 400;
                } else {
                    // Gule pladser (500 kr)
                    pladsType = PladsType.STANDARD;
                    pris = 500;
                }

                Controller.createPlads(række, nr, pris, pladsType);
            }
        }
    }

    // Metode til at udskrive forestillinger, kunder og pladser fra Storage
    public static void testPrint() {
        System.out.println("Forestillinger:");
        for (Forestilling forestilling : storage.Storage.getAllForestillinger()) {
            System.out.println("Navn: " + forestilling.getNavn() +
                    ", Spiller fra " + forestilling.getStartDato() +
                    " til " + forestilling.getSlutDato());
        }

        System.out.println("\nKunder:");
        for (Kunde kunde : storage.Storage.getAllKunder()) {
            System.out.println("Navn: " + kunde.getNavn() + ", Mobil: " + kunde.getMobil());
        }

        System.out.println("\nPladser:");
        for (Plads plads : storage.Storage.getAllPladser()) {
            System.out.println("Række: " + plads.getRække() +
                    ", Nummer: " + plads.getNr() +
                    ", Pris: " + plads.getPris() +
                    ", Type: " + plads.getPladsType());
        }
    }
}
