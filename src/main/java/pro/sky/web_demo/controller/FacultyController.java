package pro.sky.web_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.service.FacultyService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/faculty")
public class FacultyController{

    private final FacultyService facultyService;


    public FacultyController (FacultyService facultyService) { this.facultyService = facultyService; }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.findAll();
        if (faculties == null || faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return (Faculty) facultyService.addFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = (Faculty) facultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }



    @GetMapping(value = "color", params = "color")
    public ResponseEntity<Collection<Faculty>> findByColor(@RequestParam(name = "color") String color) {
        Collection<Faculty> faculties = facultyService.findByColor(color);
        if (faculties == null || faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }


            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @GetMapping(value = "{facultyId}/students")
    public ResponseEntity<List<Student>> getFacultyStudents(@PathVariable Long facultyId) {
        List<Student> students = (List<Student>) facultyService.findFaculty(facultyId).getStudents();
        if (students == null || students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/longest_names")
    public ResponseEntity<List<String>> getLongestNames() {
        Optional<List<String>> result = facultyService.findLongestFacultyNames();
        if (result.isEmpty() || result.get().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
}