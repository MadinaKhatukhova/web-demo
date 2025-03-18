package pro.sky.web_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.web_demo.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByAgeBetween(Integer min, Integer max);


    void deleteById(Long id);

    Student save(Student student);

    Student findById();
}
