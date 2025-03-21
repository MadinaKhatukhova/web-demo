package pro.sky.web_demo.service;

import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.StudentNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
        return studentRepository.findStudentsAverageAge();
    }

    @Override
    public Long findStudentsCount() {
        return 0L;
    }

    @Override
    public List<String> findStudentsWithNamesFromSymbol(String firstWord) {
        return studentRepository
                .findAll()
                .stream()
                .filter(s -> s.getName().startsWith(firstWord))
                .map(s -> s.getName().toUpperCase())
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public OptionalDouble findStudentsAverageAge2() {
        return studentRepository
                .findAll()
                .stream()
                .mapToDouble(Student::getAge)
                .average();
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
        return studentRepository.findByAgeBetween(age1, age2);
    }

    @Override
    public Collection<Student> findByAge(Integer age) {
        return studentRepository.findByAge(age);
    }

    @Override
    public Object findAll() {
        return studentRepository.findAll();
    }


}