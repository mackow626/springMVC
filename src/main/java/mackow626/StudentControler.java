package mackow626;


import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentControler {

    @RequestMapping("/pokazFormularz")
    public String pokazFormularz(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);
        return "student-formularz";
    }

    @RequestMapping("/zapisany")
    public String pokazZapisany(@ModelAttribute("student") Student student) {

        System.out.println("student "+ student.getImie() + " "+student.getNazwisko());

        return "zapisany";
    }



}
