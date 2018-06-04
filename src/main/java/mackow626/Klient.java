package mackow626;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Klient {

    @NotNull(message="is required")
    @Size(min=10, message="is required")
    private String imie1;

    @NotNull(message="is required")
    @Size(min=10, message="is required")
    private String nazwisko1;

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
