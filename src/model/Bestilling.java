package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private Forestilling forestilling;
    private List<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Kunde kunde) {
        this.dato = dato;
        this.kunde = kunde;
    }

    public LocalDate getDato() {
        return dato;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public List<Plads> getPladser() {
        return pladser;
    }

    // Sæt metode for forestilling og oprethold sammenhængen
    public void setForestilling(Forestilling forestilling) {
        this.forestilling = forestilling;
    }

    // En metode til at tilføje en plads til bestillingen
    public void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }
}
