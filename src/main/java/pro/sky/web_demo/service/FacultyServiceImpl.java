package pro.sky.web_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.FacultyNotFoundException;
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
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException());
    }

    @Override
    public void deleteFaculty(Long id) {

    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> findByNameOrColorContainsIgnoreCase(String filter) {
        return facultyRepository.findByColorIgnoreCaseOrNameIgnoreCase(filter);
    }
}




