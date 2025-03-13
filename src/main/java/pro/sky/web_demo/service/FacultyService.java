package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;

import java.util.Collection;

public abstract class FacultyService {
    public Object getFacultyById(long l) {
        return null;
    }

    public Faculty updateFaculty(double v, Faculty faculty) {
        return faculty;
    }

    public Faculty createFaculty(Faculty faculty) {
        return faculty;
    }

    public Collection<Faculty> getFilteredByColorOrName(String color, String name) {
        return java.util.List.of();
    }

    public Collection<Faculty> getAllFaculties() {
        return java.util.List.of();
    }

    public abstract Student createFaculty(Long studentId, Faculty faculty);

    public abstract Student getStudent(Long id);

    public abstract Student getFaculty(Long id);

    public abstract Student updateStudent(Long id, Student student);

    public abstract Student updateFaculty(Long id, Student student);

    public abstract Student updateFaculty(Long id, Faculty faculty);

    public abstract void removeStudent(Long id);

    public abstract Collection<Student> getByColor(Integer min, Integer max);
}
