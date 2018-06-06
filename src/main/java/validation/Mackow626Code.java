package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Mackow626Code implements ConstraintValidator<Mackow626, String> {

    private String kursPrefix;

    public void initialize(Mackow626 constraint) {
        kursPrefix = constraint.value();
    }

    public boolean isValid(String htmlDataKodKursu, ConstraintValidatorContext context) {

        if (htmlDataKodKursu!=null){
            return htmlDataKodKursu.startsWith(kursPrefix);
        }else {
            return true;
        }
    }
}
