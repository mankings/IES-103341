package pt.mankings.ies.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "user", required = false, defaultValue = "Mundo") String user, Model model) {
        model.addAttribute("name", user);
        return "greeting";
    }
}
