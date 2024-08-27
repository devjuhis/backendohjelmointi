package syksy24.testiprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/form")
    public String form(
            @RequestParam(name = "name", defaultValue = "Guest") String name,
            @RequestParam(name = "age", defaultValue = "0") int age,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "form";
    }
}

