package pro.sky.web_demo.repository;

import pro.sky.web_demo.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgBetween(Integer min, Integer max);



}
