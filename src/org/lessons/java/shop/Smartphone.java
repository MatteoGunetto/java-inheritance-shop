package org.lessons.java.shop;

class Smartphone extends Prodotto {
    private String imei;
    private  final int memoriaGB;

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