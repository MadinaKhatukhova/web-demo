package pro.sky.web_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.StudentNotFoundException;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<Student> getStudent(Long id, Student student) {
        return Optional.ofNullable(studentRepository.findById());
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
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

    @Override
    public Collection<Student> getByAge(Integer min, Integer max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Student findStudent(Long id) {
        return null;
    }
}
