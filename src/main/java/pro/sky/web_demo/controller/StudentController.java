package pro.sky.web_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) { this.studentService = studentService; }

    @GetMapping(params = {"min", "max"})

    public Collection<Student> getByAge(@RequestParam Integer min, @RequestParam Integer max) {
        return studentService.getByAge(min,max);
    }
}
