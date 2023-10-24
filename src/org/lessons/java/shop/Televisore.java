package org.lessons.java.shop;

class Televisore extends Prodotto {
    private final String dimensioni;
    private final boolean smart;

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