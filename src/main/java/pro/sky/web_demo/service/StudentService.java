package pro.sky.web_demo.service;
import pro.sky.web_demo.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student addStudent(Student student);

    Student findStudent(Long id);

    Student editStudent(Student student);

    void deleteStudent(Long id);

    Collection<Student> findByAgeBetween(Integer age1, Integer age2);

    Collection<Student> findByAge(Integer age1);
}

