package pro.sky.web_demo.repository;


import pro.sky.web_demo.model.Student;

public interface JpaRepository<S, L extends Number> {

    void deleteById(Long id);

    <T> ScopedValue<T> findById(Long id);

    Student save(Student student);
}
