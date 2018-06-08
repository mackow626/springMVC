package spring;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;


public class Student {
    @NotNull(message="musiz podac")
    private String imie;
    private String nazwisko;
    private String country;
    private String programowanie;
    private LinkedHashMap<String,String> countryOptions;
    private LinkedHashMap<String,String> programingOptions;


    public String getProgramowanie() {
        return programowanie;
    }

    public void setProgramowanie(String programowanie) {
        this.programowanie = programowanie;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public LinkedHashMap<String, String> getProgramingOptions() {
        return programingOptions;
    }

    public void setProgramingOptions(LinkedHashMap<String, String> programingOptions) {
        this.programingOptions = programingOptions;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public Student() {
        countryOptions = new LinkedHashMap<String, String>();
        countryOptions.put("POL", "Poland");
        countryOptions.put("GER", "Germany");
        countryOptions.put("USA", "United S");
        programingOptions = new LinkedHashMap<String, String>();
        programingOptions.put("Java", "Java");
        programingOptions.put("C#", "C#");
        programingOptions.put("C++", "C++");

    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Student(String imie, String nazwisko, String country, String programowanie) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.country = country;
        this.programowanie = programowanie;
    }
}
