package pro.sky.web_demo.repository.service;

import pro.sky.web_demo.model.Student;

public interface StudentService {

    Student createStudent(Long facultyId, Student student);

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);

}
