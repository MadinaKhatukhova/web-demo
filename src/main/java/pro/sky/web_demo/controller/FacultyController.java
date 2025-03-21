package pro.sky.web_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping ("/faculties")
public class FacultyController{

    private final FacultyService facultyService;


    public FacultyController (FacultyService facultyService) { this.facultyService = facultyService; }

    @GetMapping
    public Collection<Faculty> getAllFaculties() { return facultyService.getAllFaculties(); }


    @GetMapping(params = {"color", "name"})
    public Collection<Faculty> getFiltered(@RequestParam String color, @RequestParam String name){
        return facultyService.getFilteredByColorOrName(color, name);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id){
        return (Faculty) facultyService.getFacultyById(id);
    }

    @PutMapping("/{1d}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection<Student>> getFacultyStudents(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null || faculty.getStudents() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty.getStudents());
    }

}
