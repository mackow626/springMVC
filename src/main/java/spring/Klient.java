package spring;


import validation.Mackow626;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Klient {
    public Klient() {
    }

    public Klient(String imie1, String nazwisko1) {
        this.imie1 = imie1;
        this.nazwisko1 = nazwisko1;
    }

    @Size(min = 4, max = 5, message="size should be bigger then 3 an smaller then 6")
    private String imie1;

    @NotNull(message = "value is mandatory")
    @Size(min=10, message="size should be bigger then 9")
    private String nazwisko1;

    //@Pattern(regexp = "^[0-9]{5}", message = "only 5 numbers available ")
    @NotNull(message="is required")
    private Integer postalCode;

    @Mackow626(value = "LOL", message = "must start witj LOL")
    private String kodKursu;

    public String getKodKursu() {
        return kodKursu;
    }

    public void setKodKursu(String kodKursu) {
        this.kodKursu = kodKursu;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getImie1() {
        return imie1;
    }

    public void setImie1(String imie1) {
        this.imie1 = imie1;
    }

    public String getNazwisko1() {
        return nazwisko1;
    }

    public void setNazwisko1(String nazwisko1) {
        this.nazwisko1 = nazwisko1;
    }
}
