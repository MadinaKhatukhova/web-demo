package pro.sky.web_demo.service;

import org.apache.catalina.Store;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.StudentRepository;
import pro.sky.web_demo.repository.FacultyRepository;
import java.util.Collection;
import java.util.List;

public class FacultyServiceImpl extends FacultyService {

    private StudentRepository studentRepository;
    private Store facultyRepository;


    @Override
    public Student createFaculty(Long studentId, Faculty faculty) {
        return null;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public Student getFaculty(Long id) {
        return null;
    }

    @Override
    public Student updateStudent(Long id, Student student) {return null;
    }

    @Override
    public Student updateFaculty(Long id, Student student) {
        return null;
    }

    @Override
    public Student updateFaculty(Long id, Faculty faculty) {
        return null;
    }

    @Override
    public void removeStudent(Long id) {

    }

    @Override
    public Collection<Student> getByColor(Integer min, Integer max) {
        return List.of();
    }
}
