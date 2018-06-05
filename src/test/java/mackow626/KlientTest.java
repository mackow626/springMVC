package mackow626;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

class KlientTest {

    @Test
    public void licensePlateTooShort() {
        Klient klient = new Klient("","");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Klient>> constraintViolations =
                validator.validate( klient );

        when(constraintViolations.size()).thenReturn(2);

        assertEquals( 2, constraintViolations.size() );

        klientControler klientControler = new klientControler();
        BindingResult bindingResult =null;
        klientControler.processForm(klient,  bindingResult);


    }

}