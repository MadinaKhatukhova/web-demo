package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Long facultyId, Student student);

    Student getStudent(Long id);

    Optional<Student> getStudent(Long id, Student student);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);


    Collection<Student> getByAge(Integer min, Integer max);

    Student findStudent(Long id);
}