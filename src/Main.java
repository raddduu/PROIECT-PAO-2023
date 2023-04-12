import Model.*;
import Service.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProdusService produsService = new ProdusService();
        PersoanaService persoanaService = new PersoanaService();
        ComandaService comandaService = new ComandaService(produsService, persoanaService);

        boolean running = true;
        while (running) {
            System.out.println("Meniu:");
            System.out.println("1. Adauga client");
            System.out.println("2. Actualizeaza client");
            System.out.println("3. Sterge persoana");
            System.out.println("4. Cauta persoana dupa id");
            System.out.println("5. Afiseaza toate persoanele");
            System.out.println("6. Verifica daca un client se potriveste cu un restaurant");
            System.out.println("7. Verifica daca o comanda este sigura pentru client");
            System.out.println("8. Afiseaza varsta unei persoane");
            System.out.println("9. Afiseaza rating-ul unui sofer");
            System.out.println("10. Verifica daca un bucatar este valid");
            System.out.println("11. Iesire");
            System.out.print("Alege optiunea: ");
            int choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Adauga o persoana noua:");
                    persoanaService.addClient(in);
                }
                case 2 -> {
                    System.out.println("Actualizeaza persoana cu id-ul:");
                    int id = Integer.parseInt(in.nextLine());
                    persoanaService.update(id, in);
                }
                case 3 -> {
                    System.out.println("Sterge persoana dupa Id:");
                    System.out.print("Introduceti Id-ul: ");
                    int deleteId = Integer.parseInt(in.nextLine());
                    persoanaService.deletePersoanaById(deleteId);
                }
                case 4 -> {
                    System.out.println("Cauta persoana dupa Id:");
                    System.out.print("Introduceti Id-ul: ");
                    int searchId = Integer.parseInt(in.nextLine());
                    Persoana foundPerson = persoanaService.searchById(searchId);
                    if (foundPerson != null) {
                        System.out.println("Persoana gasita: " + foundPerson);
                    } else {
                        System.out.println("Persoana nu a fost gasita.");
                    }
                }

                case 5 -> {
                    System.out.println("Afiseaza toate persoanele:");

                    System.out.println("Clienti:");
                    List<Client> clients = persoanaService.getAllClienti();
                    for (Client client : clients) {
                        System.out.println(client);
                    }

                    System.out.println("Bucatari:");
                    List<Bucatar> bucatari = persoanaService.getAllBucatari();
                    for (Bucatar bucatar : bucatari) {
                        System.out.println(bucatar);
                    }

                    System.out.println("Soferi:");
                    List<Sofer> soferi = persoanaService.getAllSoferi();
                    for (Sofer sofer : soferi) {
                        System.out.println(sofer);
                    }
                }
                case 6 -> {
                    System.out.println("Introduceti id-ul clientului:");
                    int clientId = Integer.parseInt(in.nextLine());
                    System.out.println("Introduceti detalii restaurant:");
                    System.out.println("Id:");
                    int restaurantId = Integer.parseInt(in.nextLine());
                    System.out.println("Locatie Id:");
                    int locatieId = Integer.parseInt(in.nextLine());
                    System.out.println("Suprafata:");
                    int suprafata = Integer.parseInt(in.nextLine());
                    System.out.println("Nume:");
                    String nume = in.nextLine();
                    System.out.println("Specific:");
                    String specific = in.nextLine();
                    System.out.println("Numar de avize:");
                    int nrAvize = Integer.parseInt(in.nextLine());
                    List<String> lista_avize = new ArrayList<>();
                    for (int i = 0; i < nrAvize; i++) {
                        System.out.println("Aviz " + (i + 1) + ":");
                        lista_avize.add(in.nextLine());
                    }
                    Restaurant restaurant = new Restaurant(restaurantId, locatieId, suprafata, nume, specific, lista_avize);
                    if (persoanaService.sePotriveste(clientId, restaurant)) {
                        System.out.println("Clientul se potriveste cu restaurantul.");
                    } else {
                        System.out.println("Clientul nu se potriveste cu restaurantul.");
                    }
                }
                case 7 -> {
                    System.out.println("Comanda sigura:");
                    System.out.print("Introduceti Id-ul comenzii: ");
                    int comandaId = Integer.parseInt(in.nextLine());
                    boolean comandaSigura = comandaService.comandaSigura(comandaId, persoanaService);
                    System.out.println("Comanda sigura: " + comandaSigura);
                }
                case 8 -> {
                    System.out.println("Afiseaza varsta unei persoane:");
                    System.out.print("Introduceti Id-ul persoanei: ");
                    int persoanaId = Integer.parseInt(in.nextLine());
                    int age = persoanaService.getAge(persoanaId);
                    if (age != -1) {
                        System.out.println("Varsta persoanei: " + age);
                    } else {
                        System.out.println("Persoana nu a fost gasita.");
                    }
                }

                case 9 -> {
                    System.out.println("Afiseaza rating-ul unui sofer:");
                    System.out.print("Introduceti Id-ul soferului: ");
                    int soferId = Integer.parseInt(in.nextLine());
                    double rating = persoanaService.getRating(soferId);
                    if (rating != -1) {
                        System.out.println("Rating-ul soferului: " + rating);
                    } else {
                        System.out.println("Soferul nu a fost gasit.");
                    }
                }

                case 10 -> {
                    System.out.println("Verifica daca un bucatar este valid:");
                    System.out.print("Introduceti Id-ul bucatarului: ");
                    int bucatarId = Integer.parseInt(in.nextLine());
                    boolean valid = persoanaService.valid(bucatarId);
                    if (valid) {
                        System.out.println("Bucatarul este valid.");
                    } else {
                        System.out.println("Bucatarul nu este valid sau nu a fost gasit.");
                    }
                }

                case 11 -> {
                    System.out.println("Iesire");
                    running = false;
                    break;
                }

                default -> {
                    System.out.println("Optiune invalida!");
                }
            }
        }

        in.close();
    }
}