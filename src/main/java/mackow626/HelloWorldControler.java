package mackow626;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldControler {

    @RequestMapping("/dajPierwsza")
    public String dajPierwsza(){
        return "helloWorld";
    }

    @RequestMapping("/dajDruga")
    public String dajDruga(){
        return "helloWorldOdpowiedz";
    }

    @RequestMapping("/procesowanieDrugie")
    public String dajDrugieDwa(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name=" YOOOOOO   " + name.toUpperCase();

        model.addAttribute("studentName", name);

        return "helloWorldOdpowiedz";
    }

    @RequestMapping("/procesowanieTrzecie")
    public String dajDrugieTrzy(@RequestParam("studentName") String name , Model model){

        name=" v3    " + name.toUpperCase();

        model.addAttribute("studentName", name);

        return "helloWorldOdpowiedz";
    }

}
