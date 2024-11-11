package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private List<Bestilling> bestillinger = new ArrayList<>();

    // Struktur til at holde styr på de reserverede pladser
    private Map<LocalDate, List<Plads>> reserveredePladser = new HashMap<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String toString() {
        return navn + " (fra " + startDato + " til " + slutDato + ")";
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public List<Bestilling> getBestillinger() {
        return bestillinger;
    }

    // En metodee til at tilføje en bestilling
    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
            bestilling.setForestilling(this); // Oprethold dobbeltrettet sammenhæng
        }
    }

    // En metode til at tjekke, om en plads er ledig på en bestemt dato
    public boolean erPladsLedig(int række, int nr, LocalDate dato) {
        if (dato.isBefore(startDato) || dato.isAfter(slutDato)) {
            return false; // Forestillingen spiller ikke på denne dato
        }

        List<Plads> reserveredePåDato = reserveredePladser.getOrDefault(dato, new ArrayList<>());

        // Tjek om den angivne plads er i listen over reserverede pladser for den dato
        for (Plads plads : reserveredePåDato) {
            if (plads.getRække() == række && plads.getNr() == nr) {
                return false; // Hvis pladsen er reserveret
            }
        }

        return true; // Hvis pladsen er ledig
    }

    // Metode til at reservere en plads på en bestemt dato
    public void reserverPlads(int række, int nr, LocalDate dato) {
        if (!erPladsLedig(række, nr, dato)) {
            System.out.println("Pladsen er allerede reserveret på denne dato.");
            return;
        }

        List<Plads> reserveredePåDato = reserveredePladser.getOrDefault(dato, new ArrayList<>());
        reserveredePåDato.add(new Plads(række, nr));
        reserveredePladser.put(dato, reserveredePåDato);
    }
}
