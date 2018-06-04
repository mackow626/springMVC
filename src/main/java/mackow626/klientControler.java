package mackow626;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/klient")
public class klientControler {


    @RequestMapping("/pokazFormularz")
    public String pokazFormularz(Model model) {
        Klient klient = new Klient();
        model.addAttribute("klient",klient );

        return "formularzKlienta";
    }

    @RequestMapping("/zapisKlienta")
    public String processForm(@Valid @ModelAttribute("klient")  Klient klient, BindingResult theBindingResult) {

        System.out.println("nazwisko "+ klient.getNazwisko1());

        if (theBindingResult.hasErrors()) {
            return "formularzKlienta";
        } else {
            return "zapisKlienta";
        }


    }


}
