package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface StudentService {

    Student createStudent(Long facultyId, Student student);

    Student getStudent(Long id);

    Optional<Student> getStudent(Long id, Student student);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);


    Collection<Student> getByAge(Integer min, Integer max);

    Student findStudent(Long id);

    Collection<Student> findLastStudents(Integer num);

    Double findStudentsAverageAge();

    Long findStudentsCount();

    List<String> findStudentsWithNamesFromSymbol(String firstWord);

    OptionalDouble findStudentsAverageAge2();

    void printParallel();

    void printSynchronized();

    Student addStudent(Student student);

    Student editStudent(Student student);

    void deleteStudent(Long studentId);

    Collection<Student> findByAgeBetween(Integer age1, Integer age2);

    Collection<Student> findByAge(Integer age);

    Object findAll();
}

