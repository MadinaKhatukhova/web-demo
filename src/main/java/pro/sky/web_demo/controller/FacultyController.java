package pro.sky.web_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.service.FacultyService;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.findAll();
        if (faculties == null || faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = "color")
    public ResponseEntity<Collection<Faculty>> findByColor(@RequestParam(name = "color") String color) {
        Collection<Faculty> faculties = facultyService.findByColor(color);
        if (faculties == null || faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @GetMapping(params = "filter")
    public ResponseEntity<Collection<Faculty>> findByNameOrColorContainsIgnoreCase(
            @RequestParam(name = "filter") String filter) {
        Collection<Faculty> faculties = facultyService.findByNameOrColorContainsIgnoreCase(filter);
        if (faculties == null || faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("/{facultyId}/students")
    public ResponseEntity<List<Student>> getFacultyStudents(@PathVariable Long facultyId) {
        List<Student> students = (List<Student>) facultyService.findFaculty(facultyId).getStudents();
        if (students == null || students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

}