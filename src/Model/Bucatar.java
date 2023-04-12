package Model;

import java.util.Objects;

public class Bucatar extends Persoana{
    private int ani_experienta;
    private String specializare;
    private int rang;
    private int restaurantid;

    public Bucatar(int id, String prenume, String nume_de_familie, String gen, int an_nastere, int luna_nastere, int zi_nastere, int ani_experienta, String specializare, int rang, int restaurantid) {
        super(id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere);
        this.ani_experienta = ani_experienta;
        this.specializare = specializare;
        this.rang = rang;
        this.restaurantid = restaurantid;
    }

    public Bucatar() {
        super();
        this.specializare = "None";
        this.restaurantid = -1;
        this.rang = 0;
        this.ani_experienta = 0;
    }

    public int getAni_experienta() {
        return ani_experienta;
    }

    public void setAni_experienta(int ani_experienta) {
        this.ani_experienta = ani_experienta;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ani_experienta, specializare, rang, restaurantid);
    }

    @Override
    public String toString() {
        return super.toString() + "Bucatar{" +
                "ani_experienta=" + ani_experienta +
                ", specializare='" + specializare + '\'' +
                ", rang=" + rang +
                ", restaurantid=" + restaurantid +
                '}';
    }
}