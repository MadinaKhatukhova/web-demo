package pro.sky.web_demo.repository.service;

import pro.sky.web_demo.exception.StudentNotFoundException;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Long facultyId, Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return (Student) studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student wasn't found"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
