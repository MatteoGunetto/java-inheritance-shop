package org.lessons.java.shop;

import java.util.Random;
public class Prodotto {
    private int codice;
    private String nome;
    private String descrizione;
    private double prezzo;
    private int iva;

    public Prodotto(String nome, String descrizione, double prezzo, int iva) {
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

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzoBase() {
        return prezzo;
    }

    public double getPrezzoConIva() {
        return prezzo + (prezzo * iva / 100);
    }

    // Override del metodo toString \n per mandare a capo
    @Override
    public String toString() {
        return "Codice: " + codice + "\nNome: " + nome + "\nDescrizione: " + descrizione + "\nPrezzo Base: " + prezzo + "\nPrezzo con IVA: " + getPrezzoConIva();
    }
}

//Smartphone
class Smartphone extends Prodotto {
    private String imei;
    private int memoria;

    public Smartphone( String nome, String descrizione, double prezzo, int iva, String imei, int memoria) {
        super(nome, descrizione, prezzo, iva);
        this.imei = imei;
        this.memoria = memoria;
    }


    @Override
    public String toString() {
        return super.toString() + "\nIMEI: " + imei + "\nMemoria: " + memoria + " GB";
    }
}

// Televisori
class Televisore extends Prodotto {
    private int dimensioni;
    private boolean tipologia;

    public Televisore( String nome, String descrizione, double prezzo, int iva, int dimensioni, boolean tipologia) {
        super( nome, descrizione, prezzo, iva);
        this.dimensioni = dimensioni;
        this.tipologia = tipologia;
    }


    @Override
    public String toString() {
        String smartStatus = tipologia ? "Smart" : "Non Smart";
        return super.toString() + "\nDimensioni: " + dimensioni + " pollici\nTipo: " + smartStatus;
    }
}

// Cuffie
class Cuffie extends Prodotto {
    private String colore;
    private boolean connessione;

    public Cuffie( String nome, String descrizione, double prezzo, int iva, String colore, boolean connessione) {
        super( nome, descrizione, prezzo, iva);
        this.colore = colore;
        this.connessione = connessione;
    }


    @Override
    public String toString() {
        String tipo = connessione ? "Wireless" : "Cablate";
        return super.toString() + "\nColore: " + colore + "\nConnessione: " + tipo;
    }
}