package org.lessons.java.shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Prodotto> carrello = new ArrayList<>();

        while (true) {
            System.out.println("Scegli il tipo di prodotto da inserire ((1)Smartphone, (2)Televisore, (3)Cuffie, (0)Fine):");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta == 0) {
                break;
            }
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Descrizione: ");
            String descrizione = scanner.nextLine();
            System.out.print("Prezzo: ");
            double prezzo = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("IVA: ");
            int iva = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("IMEI: ");
                    String imei = scanner.nextLine();
                    System.out.print("Memoria (GB): ");
                    int memoria = scanner.nextInt();
                    carrello.add(new Smartphone( nome, descrizione, prezzo, iva, imei, memoria));
                    break;
                case 2:
                    System.out.print("Dimensioni (pollici): ");
                    int dimensioni = scanner.nextInt();
                    System.out.print("é Smart (true/false): ");
                    boolean isSmart = scanner.nextBoolean();
                    carrello.add(new Televisore( nome, descrizione, prezzo, iva, dimensioni, isSmart));
                    break;
                case 3:
                    System.out.print("Colore: ");
                    String colore = scanner.nextLine();
                    System.out.print("sono Wireless(true/false): ");
                    boolean isWireless = scanner.nextBoolean();
                    carrello.add(new Cuffie( nome, descrizione, prezzo, iva, colore, isWireless));
                    break;
            }
        }

        // Stampa il carrello
        System.out.println("Carrello:");
        for (Prodotto prodotto : carrello) {
            System.out.println(prodotto);
        }

        // Calcola il totale
        double totale = 0;
        for (Prodotto prodotto : carrello) {
            totale += prodotto.getPrezzoConIva();
        }
        System.out.println("Totale: " + totale);

        scanner.close();
    }
}