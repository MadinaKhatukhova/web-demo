package pro.sky.web_demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.StudentNotFoundException;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;


@Service
public abstract class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
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
                .orElseThrow(() -> new StudentNotFoundException());
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

    public Student addStudent(Student student) {
        logger.info("The student has been added to the application");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("findStudent method has been invoked");
        logger.debug("Requesting info for student with id: {}, id");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("editStudent method has been invoked");
        logger.error("There is no student with id");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("The student of ID has been deleted");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudent() {
        logger.info("getAllStudent method has been invoked");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween (int fromAge, int toAge) {
        logger.info("findAllStudent method has been invoked");
        return studentRepository.findByAgeBetween(fromAge, toAge);
    }

    public Optional<Student> findById(Long id) {
        logger.info("findById method has been invoked");
        logger.error("There is no student with id");
        return studentRepository.findById(id);
    }
    public Long countAllStudents() {
        logger.info("countAllStudent method has been invoked");
        return studentRepository.countAllStudents();
    }

    public Double getAverageAge() {
        logger.info("getAverageAge method has been invoked");
        return studentRepository.getAverageAge();
    }

    public Collection<Student> findFiveLast() {
        logger.info("findFiveLast method has been invoked");
        return studentRepository.findFiveLast();
    }
}
