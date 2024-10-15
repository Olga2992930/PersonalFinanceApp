package command;

import java.util.Date;

public class Transaktion {
    public String beskrivning;
    public double belopp;
    public Date datum;

    public Transaktion(String beskrivning, double belopp, Date datum) {
        this.beskrivning = beskrivning;
        this.belopp = belopp;
        this.datum = datum;
    }

    public double getBelopp() {
        return belopp;
    }

    public void visaTransaktion() {
        System.out.println("Transaktion: " + beskrivning + " | Belopp: " + belopp + " SEK | Datum: " + datum);
    }
}