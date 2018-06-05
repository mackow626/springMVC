package mackow626;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/klient")
public class klientControler {


    @RequestMapping("/pokazFormularz")
    public String pokazFormularz(Model model) {
        model.addAttribute("klient", new Klient() );

        return "formularzKlienta";
    }

    @RequestMapping("/zapisKlienta")
    public String processForm(@ModelAttribute("klient") @Valid Klient klient,BindingResult theBindingResult) {

        System.out.println("nazwisko "+ klient.getNazwisko1());

        if (theBindingResult.hasErrors()) {

            return "formularzKlienta";

        } else {
            System.out.println("brak naruszen");
            return "zapisKlienta";
        }


    }


}
