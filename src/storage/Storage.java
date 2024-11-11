package storage;

import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    // Lister til at gemme objekter
    private static List<Forestilling> forestillinger = new ArrayList<>();
    private static List<Kunde> kunder = new ArrayList<>();
    private static List<Plads> pladser = new ArrayList<>();

    // Metoder til at tilføje objekter til listerne

    public static void addForestilling(Forestilling forestilling) {
        if (!forestillinger.contains(forestilling)) {
            forestillinger.add(forestilling);
        }
    }

    public static void addKunde(Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
        }
    }

    public static void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    // Metoder til at hente alle objekter

    public static List<Forestilling> getAllForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static List<Kunde> getAllKunder() {
        return new ArrayList<>(kunder);
    }

    public static List<Plads> getAllPladser() {
        return new ArrayList<>(pladser);
    }
}
