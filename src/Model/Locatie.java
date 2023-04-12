package Model;

import java.util.Objects;

public class Locatie {
    private int id;
    private int cityid;
    private String strada;
    private int numar;

    public Locatie(int id, int cityid, String strada, int numar) {
        this.id = id;
        this.cityid = cityid;
        this.strada = strada;
        this.numar = numar;
    }

    public Locatie() {
        this(-1, -1, "None", 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatie locatie = (Locatie) o;
        return id == locatie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityid, strada, numar);
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "id=" + id +
                ", cityid=" + cityid +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                '}';
    }
}
