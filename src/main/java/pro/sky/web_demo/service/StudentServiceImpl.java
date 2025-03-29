package pro.sky.web_demo.service;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.StudentNotFoundException;
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
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public Collection<Student> findByAgeBetween(Integer age1, Integer age2) {
        return studentRepository.findByAgeBetween(age1, age2);
    }

    @Override
    public Collection<Student> findByAge(Integer age1) {
        return studentRepository.findAll();
    }


    // parallel streams

    @Override
    public List<String> getStudentsNameStartsWithA() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("A"))
                .sorted()
                .toList();
    }

    @Override
    public Double getAverageAgeOfStudents() {
        return studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    // потоки

    public void printStudentsNamesWithThreads() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList.get(0).getName());
        System.out.println(studentList.get(1).getName());

        new Thread(() -> {
            System.out.println(studentList.get(2).getName());
            System.out.println(studentList.get(3).getName());
        }).start();

        new Thread(() -> {
            System.out.println(studentList.get(4).getName());
            System.out.println(studentList.get(5).getName());
        }).start();
    }

    @Override
    public void printStudentsNamesWithSynchronizedThreads() {
        List<Student> studentList = studentRepository.findAll();

        printStudentName(studentList);
        printStudentName(studentList);

        new Thread(() -> {
            printStudentName(studentList);
            printStudentName(studentList);
        }).start();

    }

    @Override
    public void printStudentName(List<Student> studentList) {

    }

    @Override
    public void printStudentsNameWithThreads() {

    }

}



