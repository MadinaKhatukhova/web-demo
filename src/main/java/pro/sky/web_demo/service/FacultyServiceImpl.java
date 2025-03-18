package pro.sky.web_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.repository.FacultyRepository;
import java.util.Collection;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty() {
        return null;
    }

    @Override
    public Faculty getFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Object getFacultyById(Long id) {
        return null;
    }

    @Override
    public Collection<Faculty> getFilteredByColorOrName(String color, String name) {
        return List.of();
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return List.of();
    }
}







