package Model;

import java.util.*;

public class Client extends Persoana{
    private String tip_mancare_preferat;
    private int nr_alergii;
    private SortedMap<String, Integer> alergii_gravitate;

    public Client(int id, String prenume, String nume_de_familie, String gen, int an_nastere, int luna_nastere, int zi_nastere, String tip_mancare_preferat, int nr_alergii, SortedMap<String, Integer> alergii_gravitate) {
        super(id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere);
        this.tip_mancare_preferat = tip_mancare_preferat;
        this.nr_alergii = nr_alergii;
        this.alergii_gravitate = alergii_gravitate;
    }

    public Client() {
        super();
        this.tip_mancare_preferat = "None";
        this.nr_alergii = 0;
        this.alergii_gravitate = new TreeMap<>();
    }

    public String getTip_mancare_preferat() {
        return tip_mancare_preferat;
    }

    public void setTip_mancare_preferat(String tip_mancare_preferat) {
        this.tip_mancare_preferat = tip_mancare_preferat;
    }

    public int getNr_alergii() {
        return nr_alergii;
    }

    public void setNr_alergii(int nr_alergii) {
        this.nr_alergii = nr_alergii;
    }

    public SortedMap<String, Integer> getAlergii_gravitate() {
        return alergii_gravitate;
    }

    public void setAlergii_gravitate(SortedMap<String, Integer> alergii_gravitate) {
        this.alergii_gravitate = alergii_gravitate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tip_mancare_preferat, nr_alergii, alergii_gravitate);
    }

    @Override
    public String toString() {
        return super.toString() + "Client{" +
                "tip_mancare_preferat='" + tip_mancare_preferat + '\'' +
                ", nr_alergii=" + nr_alergii +
                ", alergii_gravitate=" + alergii_gravitate +
                '}';
    }
}
