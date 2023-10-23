package org.lessons.java.shop;


import java.util.Scanner;

class Carrello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totale = 0;

        System.out.print("Hai una tessera fedeltà? (si/no): ");
        boolean tesseraFedelta = scanner.nextLine().equalsIgnoreCase("si");

        while (true) {
            System.out.print("Inserisci un prodotto (Smartphone/Televisore/Cuffie/esci): ");
            String scelta = scanner.nextLine();
            if (scelta.equalsIgnoreCase("esci")) {
                break;
            }

            String nome;
            String descrizione;
            double prezzo;
            double iva;



            System.out.print("Nome: ");
            nome = scanner.nextLine();

            System.out.print("Descrizione: ");
            descrizione = scanner.nextLine();

            System.out.print("Prezzo: ");
            prezzo = Double.parseDouble(scanner.nextLine());

            System.out.print("Iva: ");
            iva = Double.parseDouble(scanner.nextLine());

            Prodotto prodotto = null;

            if (scelta.equalsIgnoreCase("Smartphone")) {
                System.out.print("IMEI: ");
                String imei = scanner.nextLine();

                System.out.print("Memoria (GB): ");
                int memoriaGB = Integer.parseInt(scanner.nextLine());

                prodotto = new Smartphone( nome, descrizione, prezzo, iva, imei, memoriaGB);
            }
            else if (scelta.equalsIgnoreCase("Televisore")) {
                System.out.print("Dimensioni: ");
                String dimensioni = scanner.nextLine();

                System.out.print("Smart TV (si/no): ");
                boolean isSmart = scanner.nextLine().equalsIgnoreCase("si");

                prodotto = new Televisore( nome, descrizione, prezzo, iva, dimensioni, isSmart);
            } else if (scelta.equalsIgnoreCase("Cuffie")) {
                System.out.print("Colore: ");
                String colore = scanner.nextLine();

                System.out.print("Wireless (si/no): ");
                boolean isWireless = scanner.nextLine().equalsIgnoreCase("si");

                prodotto = new Cuffie( nome, descrizione, prezzo, iva, colore, isWireless);
            }

            if (prodotto != null) {
                totale += tesseraFedelta ? prodotto.getPrezzoScontato(tesseraFedelta) : prodotto.getPrezzo();
                System.out.println("Prodotto aggiunto al carrello:\n" + prodotto.toString());
            }
        }

        System.out.println("Totale: " + String.format("%.2f", totale));
        scanner.close();
    }
}