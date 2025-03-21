package pro.sky.web_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.web_demo.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetween(Integer min, Integer max);

    Student findStudent(Long id);

    Collection<Student> findLastStudents(Integer num);

    Student addStudent(Student student);

    Student editStudent(Student student);

    Double findStudentsAverageAge();
}

