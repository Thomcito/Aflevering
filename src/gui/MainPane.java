package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Forestilling;
import model.Kunde;
import storage.Storage;

import java.time.LocalDate;

public class MainPane extends GridPane {

    private ListView<Forestilling> lvwForestillinger;
    private ListView<Kunde> lvwKunder;
    private TextField txfForestillingNavn, txfStartDato, txfSlutDato;
    private TextField txfKundeNavn, txfKundeMobil;

    public MainPane() {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        // Forestillinger ListView
        Label lblForestillinger = new Label("Forestillinger");
        this.add(lblForestillinger, 0, 0);

        lvwForestillinger = new ListView<>();
        lvwForestillinger.setPrefWidth(200);
        lvwForestillinger.setPrefHeight(200);
        this.add(lvwForestillinger, 0, 1);
        lvwForestillinger.getItems().setAll(Storage.getAllForestillinger());

        // Kunder ListView
        Label lblKunder = new Label("Kunder");
        this.add(lblKunder, 1, 0);

        lvwKunder = new ListView<>();
        lvwKunder.setPrefWidth(200);
        lvwKunder.setPrefHeight(200);
        this.add(lvwKunder, 1, 1);
        lvwKunder.getItems().setAll(Storage.getAllKunder());

        // Forestilling form
        txfForestillingNavn = new TextField();
        txfStartDato = new TextField();
        txfSlutDato = new TextField();
        Button btnOpretForestilling = new Button("Opret forestilling");
        btnOpretForestilling.setOnAction(event -> opretForestillingAction());

        this.add(new Label("Navn"), 0, 2);
        this.add(txfForestillingNavn, 0, 3);
        this.add(new Label("Start dato"), 0, 4);
        this.add(txfStartDato, 0, 5);
        this.add(new Label("Slut dato"), 0, 6);
        this.add(txfSlutDato, 0, 7);
        this.add(btnOpretForestilling, 0, 8);

        // Kunde form
        txfKundeNavn = new TextField();
        txfKundeMobil = new TextField();
        Button btnOpretKunde = new Button("Opret kunde");
        btnOpretKunde.setOnAction(event -> opretKundeAction());

        this.add(new Label("Kunde navn"), 1, 2);
        this.add(txfKundeNavn, 1, 3);
        this.add(new Label("Kunde mobil"), 1, 4);
        this.add(txfKundeMobil, 1, 5);
        this.add(btnOpretKunde, 1, 6);
    }

    // Opretter en ny forestilling
    private void opretForestillingAction() {
        String navn = txfForestillingNavn.getText().trim();
        LocalDate startDato = LocalDate.parse(txfStartDato.getText().trim());
        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText().trim());

        Forestilling forestilling = Controller.createForestilling(navn, startDato, slutDato);
        lvwForestillinger.getItems().setAll(Storage.getAllForestillinger());
    }

    // Opretter en ny kunde
    private void opretKundeAction() {
        String navn = txfKundeNavn.getText().trim();
        String mobil = txfKundeMobil.getText().trim();

        Kunde kunde = Controller.createKunde(navn, mobil);
        lvwKunder.getItems().setAll(Storage.getAllKunder());
    }
}
