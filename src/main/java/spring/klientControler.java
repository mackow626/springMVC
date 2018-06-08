package spring;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/klient")
public class klientControler {


    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/pokazFormularz")
    public String pokazFormularz(Model model) {
        model.addAttribute("klient", new Klient() );

        return "formularzKlienta";
    }

    @RequestMapping("/zapisKlienta")
    public String processForm(@ModelAttribute("klient") @Valid Klient klient,BindingResult theBindingResult) {

        System.out.println("nazwisko "+ klient.getNazwisko1());

        System.out.println("Binding reslt" + theBindingResult);
        if (theBindingResult.hasErrors()) {

            return "formularzKlienta";

        } else {
            System.out.println("brak naruszen");
            return "zapisKlienta";
        }


    }


}
