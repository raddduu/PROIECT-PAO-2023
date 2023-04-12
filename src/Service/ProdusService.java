package Service;

import Model.Produs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdusService {
    private List<Produs> produse = new ArrayList<>();

    public void addProdus(Scanner in) {
        System.out.println("Id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Denumire: ");
        String denumire = in.nextLine();
        System.out.println("Numar alergeni: ");
        int nralergeni = Integer.parseInt(in.nextLine());
        List<String> alergeni = new ArrayList<>();
        for (int i = 0; i < nralergeni; i++) {
            System.out.println("Alergen " + (i + 1) + ": ");
            alergeni.add(in.nextLine());
        }
        System.out.println("Numar ingrediente: ");
        int nringrediente = Integer.parseInt(in.nextLine());
        List<String> ingrediente = new ArrayList<>();
        for (int i = 0; i < nringrediente; i++) {
            System.out.println("Ingredient " + (i + 1) + ": ");
            ingrediente.add(in.nextLine());
        }
        System.out.println("Pret: ");
        double pret = Double.parseDouble(in.nextLine());

        Produs produs = new Produs(id, denumire, nralergeni, alergeni, nringrediente, ingrediente, pret);
        produse.add(produs);
    }

    public List<Produs> getAllProduse() {
        return new ArrayList<>(produse);
    }

    public int findProdusById(int id) {
        for (int i = 0; i < produse.size(); i++) {
            Produs produs = produse.get(i);
            if (produs.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Produs searchById(int id) {
        for (Produs produs : produse) {
            if (produs.getId() == id) {
                return produs;
            }
        }
        return null;
    }

    public void deleteProdusById(int id) {
        int index = findProdusById(id);
        if (index != -1) {
            produse.remove(index);
            System.out.println("Produsul cu id-ul " + id + " a fost sters.");
        } else {
            System.out.println("Nu exista produsul cu Id-ul " + id + ".");
        }
    }

    public void update(int id, Scanner in) {
        Produs produs = searchById(id);
        if (produs != null) {
            System.out.println("Denumire: ");
            String denumire = in.nextLine();
            System.out.println("Pret: ");
            double pret = Double.parseDouble(in.nextLine());

            produs.setDenumire(denumire);
            produs.setPret(pret);
        } else {
            System.out.println("Produsul cu Id-ul " + id + " nu exista.");
        }
    }


}
