package pro.sky.web_demo.service;

import io.micrometer.observation.Observation;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.FacultyNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.repository.FacultyRepository;
import java.util.Collection;
import java.util.List;

@Service
public abstract class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
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
    public Collection<Faculty> getFilteredByColorOrName(String color, String name) {
        return facultyRepository.getFilteredByColorOrName(color, name);
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.getAllFaculties();
    }


}







