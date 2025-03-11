package pro.sky.web_demo.repository.service;

import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Long facultyId, Student student){
        return null;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public void removeStudent(Long id) {

    }
}
