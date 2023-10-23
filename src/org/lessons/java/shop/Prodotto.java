package org.lessons.java.shop;


import java.util.Random;
class Prodotto {
    private final int codice;
    private String nome;
    private String descrizione;
    private double prezzo;
    private double iva;

    public Prodotto(String nome, String descrizione, double prezzo, double iva) {
        this.codice = codiceRandom();
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    private int codiceRandom() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double getPrezzoConIva() {
        return prezzo + (prezzo * iva / 100);
    }

    public double getPrezzoScontato(boolean tesseraFedelta) {
        double sconto = tesseraFedelta ? 0.02 : 0.0;
        return prezzo - (prezzo * sconto);
    }
    // Override del metodo toString \n per mandare a capo
    @Override
    public String toString() {
        return "Codice: " + codice +
                "\nNome: " + nome +
                "\nDescrizione: " + descrizione +
                "\nPrezzo: " + prezzo +
                "\nIva: " + iva;
    }
}

class Smartphone extends Prodotto {
    private String imei;
    private int memoriaGB;

    public Smartphone( String nome, String descrizione, double prezzo, double iva, String imei, int memoriaGB) {
        super( nome, descrizione, prezzo, iva);
        this.imei = imei;
        this.memoriaGB = memoriaGB;
    }

    @Override
    public double getPrezzoScontato(boolean tesseraFedelta) {
        double scontoBase = tesseraFedelta ? 0.02 : 0.0;
        double scontoMemoria = (memoriaGB < 32) ? 0.0 : 0.05;
        return getPrezzo() - (getPrezzo() * (scontoBase + scontoMemoria));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nIMEI: " + imei +
                "\nMemoria: " + memoriaGB + "GB";
    }
}

class Televisore extends Prodotto {
    private String dimensioni;
    private boolean smart;

    public Televisore( String nome, String descrizione, double prezzo, double iva, String dimensioni, boolean smart) {
        super( nome, descrizione, prezzo, iva);
        this.dimensioni = dimensioni;
        this.smart = smart;
    }

    @Override
    public double getPrezzoScontato(boolean tesseraFedelta) {
        double scontoBase = tesseraFedelta ? 0.02 : 0.0;
        double scontoSmart = (smart) ? 0.0 : 0.10;
        return getPrezzo() - (getPrezzo() * (scontoBase + scontoSmart));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDimensioni: " + dimensioni +
                "\nSmart TV: " + (smart ? "Si" : "No");
    }
}

class Cuffie extends Prodotto {
    private String colore;
    private boolean connessione;

    public Cuffie( String nome, String descrizione, double prezzo, double iva, String colore, boolean connessione) {
        super( nome, descrizione, prezzo, iva);
        this.colore = colore;
        this.connessione = connessione;
    }

    @Override
    public double getPrezzoScontato(boolean tesseraFedelta) {
        double scontoBase = tesseraFedelta ? 0.02 : 0.0;
        double scontoCablate = (connessione) ? 0.0 : 0.07 ;
        return getPrezzo() - (getPrezzo() * (scontoBase + scontoCablate));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nColore: " + colore +
                "\nWireless: " + (connessione ? "Si" : "No");
    }
}
