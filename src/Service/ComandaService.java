package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ComandaService {
    private List<Comanda> comenzi = new ArrayList<>();
    private ProdusService produsService;
    private PersoanaService persoanaService;

    public ComandaService(ProdusService produsService, PersoanaService persoanaService) {
        this.produsService = produsService;
        this.persoanaService = persoanaService;
    }

    public void addComanda(Scanner in) {
        System.out.println("Id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Client Id: ");
        int clientid = Integer.parseInt(in.nextLine());
        System.out.println("Sofer Id: ");
        int soferid = Integer.parseInt(in.nextLine());

        System.out.println("Numar de produse: ");
        int nrProduse = Integer.parseInt(in.nextLine());
        List<Produs> produse = new ArrayList<>();
        for (int i = 0; i < nrProduse; i++) {
            System.out.println("Id produs: ");
            int produsId = Integer.parseInt(in.nextLine());
            Produs produs = produsService.searchById(produsId);
            produse.add(produs);
        }

        System.out.println("Numar de bucatari participanti: ");
        int nrBucatari = Integer.parseInt(in.nextLine());
        List<Bucatar> bucatari_participanti = new ArrayList<>();
        for (int i = 0; i < nrBucatari; i++) {
            System.out.println("Id bucatar: ");
            int bucatarId = Integer.parseInt(in.nextLine());
            Bucatar bucatar = (Bucatar) persoanaService.searchById(bucatarId);
            bucatari_participanti.add(bucatar);
        }

        Comanda comanda = new Comanda(id, clientid, soferid, produse, bucatari_participanti);
        comenzi.add(comanda);
    }

    public List<Comanda> getAllComenzi() {
        return comenzi;
    }

    public int findComandaById(int id) {
        for (int i = 0; i < comenzi.size(); i++) {
            Comanda comanda = comenzi.get(i);
            if (comanda.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Comanda searchById(int id) {
        for (Comanda comanda : comenzi) {
            if (comanda.getId() == id) {
                return comanda;
            }
        }
        return null;
    }

    public void deleteComandaById(int id) {
        int index = findComandaById(id);
        if (index != -1) {
            comenzi.remove(index);
            System.out.println("Comanda cu id-ul " + id + " a fost stearsa.");
        } else {
            System.out.println("Nu exista comanda cu Id-ul " + id + ".");
        }
    }

    public void update(int id, Scanner in) {
        Comanda comanda = searchById(id);
        if (comanda != null) {
            System.out.println("Client Id: ");
            int clientid = Integer.parseInt(in.nextLine());
            System.out.println("Sofer Id: ");
            int soferid = Integer.parseInt(in.nextLine());
            System.out.println("Numar de produse: ");
            int nrProduse = Integer.parseInt(in.nextLine());
            List<Produs> produse = new ArrayList<>();
            for (int i = 0; i < nrProduse; i++) {
                System.out.println("Id produs: ");
                int produsId = Integer.parseInt(in.nextLine());
                Produs produs = produsService.searchById(produsId);
                produse.add(produs);
            }
            System.out.println("Numar de bucatari participanti: ");
            int nrBucatari = Integer.parseInt(in.nextLine());
            List<Bucatar> bucatari_participanti = new ArrayList<>();
            for (int i = 0; i < nrBucatari; i++) {
                System.out.println("Id bucatar: ");
                int bucatarId = Integer.parseInt(in.nextLine());
                Bucatar bucatar = (Bucatar) persoanaService.searchById(bucatarId);
                bucatari_participanti.add(bucatar);
            }

            comanda.setClientid(clientid);
            comanda.setSoferid(soferid);
            comanda.setProduse(produse);
            comanda.setBucatari_participanti(bucatari_participanti);
            System.out.println("Comanda cu id-ul " + id + " a fost actualizata.");
        } else {
            System.out.println("Nu exista comanda cu Id-ul " + id + ".");
        }
    }

    public boolean comandaSigura(int id, PersoanaService clientService) {
        Comanda comanda = searchById(id);
        if (comanda == null) {
            System.out.println("Comanda cu Id-ul " + id + " nu exista.");
            return false;
        }

        Client client = (Client) clientService.searchById(comanda.getClientid());
        if (client == null) {
            System.out.println("Clientul cu Id-ul " + client.getId() + " nu exista.");
            return false;
        }

        SortedMap<String, Integer> alergeni_gravitate = client.getAlergii_gravitate();
        List<Produs> produse = comanda.getProduse();

        for (Produs produs : produse) {
            List<String> alergeni = produs.getAlergeni();
            for (String productAllergen : alergeni) {
                if (alergeni_gravitate.containsKey(productAllergen) && alergeni_gravitate.get(productAllergen) >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

}

