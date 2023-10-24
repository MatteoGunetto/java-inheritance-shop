package org.lessons.java.shop;


import java.util.Random;
class Prodotto {
    private final int codice;
    private String nome;
    private String descrizione;
    private final double prezzo;
    private  final double iva;

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






