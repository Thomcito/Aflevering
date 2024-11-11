package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private List<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
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

    // Metode til at tilføje en bestilling
    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
            bestilling.setForestilling(this); // Oprethold dobbeltrettet sammenhæng
        }
    }
}
