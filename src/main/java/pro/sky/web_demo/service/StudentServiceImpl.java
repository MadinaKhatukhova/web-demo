package pro.sky.web_demo.service;

import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.StudentNotFoundException;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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
        return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException());
    }

    @Override
    public Optional<Student> getStudent(Long id, Student student) {
        return Optional.empty();
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
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException());
    }

    @Override
    public Collection<Student> findLastStudents(Integer num) {
        return studentRepository.findLastStudents(num);
    }


    @Override
    public Double findStudentsAverageAge() {
        return 0.0;
    }

    @Override
    public Long findStudentsCount() {
        return 0L;
    }

    @Override
    public List<String> findStudentsWithNamesFromSymbol(String firstWord) {
        return List.of();
    }

    @Override
    public OptionalDouble findStudentsAverageAge2() {
        return OptionalDouble.empty();
    }

    @Override
    public void printParallel() {

    }

    @Override
    public void printSynchronized() {

    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.editStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public Collection<Student> findByAgeBetween(Integer age1, Integer age2) {
        return List.of();
    }

    @Override
    public Collection<Student> findByAge(Integer age) {
        return List.of();
    }

    @Override
    public Object findAll() {
        return studentRepository.findAll();
    }
}