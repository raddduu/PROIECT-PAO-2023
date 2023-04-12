package Model;

import java.util.Objects;

public class Sofer extends Persoana{
    private int ani_experienta;
    private int nr_clienti;
    private int scor_total;
    /*public double calculeaza_rating() {
        return 1.0 * scor_total / nr_clienti;
    }*/

    public Sofer(int id, String prenume, String nume_de_familie, String gen, int an_nastere, int luna_nastere, int zi_nastere, int ani_experienta, int nr_clienti, int scor_total) {
        super(id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere);
        this.ani_experienta = ani_experienta;
        this.nr_clienti = nr_clienti;
        this.scor_total = scor_total;
    }

    public Sofer() {
        this(-1, "None", "None", "None", 0, 0, 0, 0, 0, 0);
    }

    public int getAni_experienta() {
        return ani_experienta;
    }

    public void setAni_experienta(int ani_experienta) {
        this.ani_experienta = ani_experienta;
    }

    public int getNr_clienti() {
        return nr_clienti;
    }

    public void setNr_clienti(int nr_clienti) {
        this.nr_clienti = nr_clienti;
    }

    public int getScor_total() {
        return scor_total;
    }

    public void setScor_total(int scor_total) {
        this.scor_total = scor_total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ani_experienta, nr_clienti, scor_total);
    }

    @Override
    public String toString() {
        return super.toString() + "Sofer{" +
                "ani_experienta=" + ani_experienta +
                ", nr_clienti=" + nr_clienti +
                ", scor_total=" + scor_total +
                '}';
    }
}
