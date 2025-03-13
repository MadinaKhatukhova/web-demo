package pro.sky.web_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Long facultyId, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public Student getStudent(Long id, Student student) {
        return studentRepository.save(student);

    }


    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Collection<Student> getByAge(Integer min, Integer max) {
        return List.of();
    }
}
