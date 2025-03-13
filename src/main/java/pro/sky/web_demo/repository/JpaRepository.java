package pro.sky.web_demo.repository;


import pro.sky.web_demo.model.Student;

public interface JpaRepository {

    void deleteById(Long id);

    Student save(Student student);

}
