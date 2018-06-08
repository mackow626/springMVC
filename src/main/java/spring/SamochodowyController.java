package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/garaz")
public class SamochodowyController {

    @RequestMapping("/Samochody")
    public String dajSamochody(){

        return "samochody";
    }

}
