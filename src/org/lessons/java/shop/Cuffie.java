package org.lessons.java.shop;

class Cuffie extends Prodotto {
    private final String colore;
    private final  boolean connessione;

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