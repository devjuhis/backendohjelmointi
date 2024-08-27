package syksy24.testiprojekti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import syksy24.testiprojekti.domain.Student;

@Controller
public class HelloController {

    //tehtävä1
    @GetMapping("/userage")
    public String form(
            @RequestParam(name = "name", defaultValue = "Guest") String name,
            @RequestParam(name = "age", defaultValue = "0") int age,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "userage";
    }

    //tehtävä2
    @GetMapping("/hello")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        model.addAttribute("students", students);
        return "hello";
    }

    //tehtävä3
     private List<Student> students = new ArrayList<>();

    @GetMapping("/index")
    public String getFriends(Model model) {
        // Add initial students if the list is empty
        if (students.isEmpty()) {
            students.add(new Student("Kate", "Cole"));
            students.add(new Student("Dan", "Brown"));
            students.add(new Student("Mike", "Mars"));
        }

        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/addFriend")
    public String addFriends(@ModelAttribute Student student, Model model) {
        students.add(student); // Add the new student to the list
        model.addAttribute("students", students);
        model.addAttribute("student", new Student()); // Reset the form
        return "redirect:/index"; // Redirect to /index to show the updated list
    }
}

