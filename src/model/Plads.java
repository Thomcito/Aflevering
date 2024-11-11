package model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }
    // Ny konstruktor så "RerserveredePåDato" i forestilling kan addes
    public Plads(int række, int nr) {
        this.række = række;
        this.nr = nr;
        this.pris = 0;
        this.pladsType = PladsType.STANDARD;
    }


    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getPladsType() {
        return pladsType;
    }
}
