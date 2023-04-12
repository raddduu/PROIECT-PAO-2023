package Service;

import Model.Bucatar;
import Model.Client;
import Model.Persoana;
import Model.Sofer;
import Model.Restaurant;

import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;

public class PersoanaService {
    private List<Persoana> persoane = new ArrayList<>();
    public void addBucatar(Scanner in) {
        System.out.println("Nume: ");
        String nume = in.nextLine();
        System.out.println("Prenume: ");
        String prenume = in.nextLine();
        System.out.println("Id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Gen: ");
        String gen = in.nextLine();
        System.out.println("Anul nasterii: ");
        int an = Integer.parseInt(in.nextLine());
        System.out.println("Luna nasterii: ");
        int luna = Integer.parseInt(in.nextLine());
        System.out.println("Ziua nasterii: ");
        int ziua = Integer.parseInt(in.nextLine());
        System.out.println("Ani de experienta: ");
        int exp = Integer.parseInt(in.nextLine());
        System.out.println("Specializare: ");
        String specializare = in.nextLine();
        System.out.println("Rang: ");
        int rang = Integer.parseInt(in.nextLine());
        System.out.println("Id restaurant: ");
        int rid = Integer.parseInt(in.nextLine());
        Bucatar bucatar = new Bucatar(id, prenume, nume, gen, an, luna, ziua, exp, specializare, rang, rid);
        persoane.add(bucatar);
        if (!valid(id)) {
            deletePersoanaById(id);
        }
    }
    public void addClient(Scanner in) {
        System.out.println("Nume: ");
        String nume = in.nextLine();
        System.out.println("Prenume: ");
        String prenume = in.nextLine();
        System.out.println("Id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Gen: ");
        String gen = in.nextLine();
        System.out.println("Anul nasterii: ");
        int an = Integer.parseInt(in.nextLine());
        System.out.println("Luna nasterii: ");
        int luna = Integer.parseInt(in.nextLine());
        System.out.println("Ziua nasterii: ");
        int ziua = Integer.parseInt(in.nextLine());
        System.out.println("Categorie de mancare preferata: ");
        String mancare_preferata = in.nextLine();
        System.out.println("Numar alergii: ");
        int nralg = Integer.parseInt(in.nextLine());
        System.out.println("Alergiile si gravitatea lor(de la 1 usoara la 5 letala): ");

        HashMap<String, Integer> alergii_gravitate = new HashMap<>();
        for (int i = 0; i < nralg; i++) {
            System.out.println("Substanta alergen: ");
            String alergie = in.nextLine();
            System.out.println("Gradul de gravitate: ");
            int gravitate = Integer.parseInt(in.nextLine());
            alergii_gravitate.put(alergie, gravitate);
        }

        SortedMap<String, Integer> sortate = new TreeMap<>(alergii_gravitate);

        Client client = new Client(id, prenume, nume, gen, an, luna, ziua, mancare_preferata, nralg, sortate);
        persoane.add(client);
        if (!valid(id)) {
            deletePersoanaById(id);
        }
    }

    public void addSofer(Scanner in) {
        System.out.println("Nume: ");
        String nume = in.nextLine();
        System.out.println("Prenume: ");
        String prenume = in.nextLine();
        System.out.println("Id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Gen: ");
        String gen = in.nextLine();
        System.out.println("Anul nasterii: ");
        int an = Integer.parseInt(in.nextLine());
        System.out.println("Luna nasterii: ");
        int luna = Integer.parseInt(in.nextLine());
        System.out.println("Ziua nasterii: ");
        int ziua = Integer.parseInt(in.nextLine());
        System.out.println("Ani de experienta: ");
        int exp = Integer.parseInt(in.nextLine());
        System.out.println("Numar client: ");
        int nrc = Integer.parseInt(in.nextLine());
        System.out.println("Scor total: ");
        int scor = Integer.parseInt(in.nextLine());
        Sofer sofer = new Sofer(id, prenume, nume, gen, an, luna, ziua, exp, nrc, scor);
        persoane.add(sofer);
        if (!valid(id)) {
            deletePersoanaById(id);
        }
    }

    public List<Client> getAllClienti() {
        List<Client> clienti = new ArrayList<>();
        for (Persoana persoana : persoane) {
            if (persoana instanceof Client) {
                clienti.add((Client) persoana);
            }
        }
        return clienti;
    }
    public List<Sofer> getAllSoferi() {
        List<Sofer> soferi = new ArrayList<>();
        for (Persoana persoana : persoane) {
            if (persoana instanceof Sofer) {
                soferi.add((Sofer) persoana);
            }
        }
        return soferi;
    }

    public List<Bucatar> getAllBucatari() {
        List<Bucatar> bucatari = new ArrayList<>();
        for (Persoana persoana : persoane) {
            if (persoana instanceof Bucatar) {
                bucatari.add((Bucatar) persoana);
            }
        }
        return bucatari;
    }

    public int findPersoanaById(int id) {
        for (int i = 0; i < persoane.size(); i++) {
            Persoana persoana = persoane.get(i);
            if (persoana.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Persoana searchById(int id) {
        for (Persoana persoana : persoane) {
            if (persoana.getId() == id) {
                return persoana;
            }
        }
        return null;
    }
    public void deletePersoanaById(int id) {
        int index = findPersoanaById(id);
        if (index != -1) {
            persoane.remove(index);
            System.out.println("Persoana cu id-ul " + id + " a fost stearsa.");
        }
        else {
            System.out.println("Nu exista persoana cu Id-ul " + id + ".");
        }
    }
    public void update(int id, Scanner in) {
        Persoana persoana = searchById(id);
        if (persoana != null) {
            System.out.println("Nume: ");
            String nume = in.nextLine();
            System.out.println("Prenume: ");
            String prenume = in.nextLine();
            System.out.println("Gen: ");
            String gen = in.nextLine();
            persoana.setNume_de_familie(nume);
            persoana.setPrenume(prenume);
            persoana.setGen(gen);
        }
        else {
            System.out.println("Persoana cu Id-ul " + id + " nu exista.");
        }
    }

    public int getAge(int id) {
        Persoana persoana = searchById(id);
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(persoana.getAn_nastere(), persoana.getLuna_nastere(), persoana.getZi_nastere());
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
    }

    public double getRating(int id) {
        Persoana persoana = searchById(id);
        if (persoana instanceof Sofer) {
            Sofer sofer = (Sofer) persoana;
            return 1.0 * sofer.getScor_total() / sofer.getNr_clienti();
        }

        return -1;
    }

    public boolean valid(int id) {
        Persoana persoana = searchById(id);
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(persoana.getAn_nastere(), persoana.getLuna_nastere(), persoana.getZi_nastere());
        int year = persoana.getAn_nastere();
        int month = persoana.getLuna_nastere();
        int day = persoana.getZi_nastere();
        if (year < 1850 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        try {
            YearMonth yearMonth = YearMonth.of(year, month);
            yearMonth.atDay(day);

            if (!currentDate.isAfter(birthDate)) {
                return false;
            }

            if (persoana instanceof Client) {
                Client client = (Client) persoana;
                SortedMap<String, Integer> alergii = client.getAlergii_gravitate();
                for (String key : alergii.keySet()) {
                    Integer gravitate = alergii.get(key);
                    if (gravitate > 5 || gravitate < 1) {
                        return false;
                    }
                }
                return true;
            }

            if (persoana instanceof Sofer) {
                Sofer sofer = (Sofer) persoana;
                return sofer.getAni_experienta() >= 0 && sofer.getNr_clienti() >= 0 && sofer.getScor_total() >= 0;
            }

            if (persoana instanceof Bucatar) {
                Bucatar bucatar = (Bucatar) persoana;
                return bucatar.getAni_experienta() >= 0 && bucatar.getRang() >= 1 && bucatar.getRang() <= 3;
            }

            return true;
        }
         catch (Exception e) {
            return false;
        }
    }

    public boolean sePotriveste(int id, Restaurant restaurant) {
        Client client = (Client) searchById(id);
        if (client == null) {
            System.out.println("Clientul nu exista.");
            return false;
        }

        if (restaurant == null) {
            System.out.println("Restaurantul nu exista.");
            return false;
        }

        String mancarea_preferata = client.getTip_mancare_preferat();
        String specific = restaurant.getSpecific();

        return mancarea_preferata.equals(specific);
    }
}
