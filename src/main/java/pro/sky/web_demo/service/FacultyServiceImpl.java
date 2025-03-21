package pro.sky.web_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.FacultyNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.repository.FacultyRepository;
import pro.sky.web_demo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> findAll() {
        return List.of();
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.createFaculty(faculty);
    }

    @Override
    public Faculty getFaculty() {
        return facultyRepository.getFaculty();
    }

    @Override
    public Faculty getFaculty(Long id, Faculty faculty) {
        return facultyRepository.getFaculty(id, faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        return facultyRepository.updateFaculty(id, faculty);
    }

    @Override
    public void removeFaculty(Long id) {

    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow(()-> new FacultyNotFoundException());
    }

    @Override
    public Collection<Faculty> getFilteredByColorOrName(String color, String name) {
        return facultyRepository.getFilteredByColorOrName(color, name);
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.getAllFaculties();
    }

    @Override
    public Faculty findFaculty(Long id) {
        return facultyRepository.findFaculty(id);
    }

    @Override
    public void deleteFaculty(Long id) {

    }

    @Override
    public Object editFaculty(Faculty any) {
        return facultyRepository.editFaculty(any);
    }

    @Override
    public Object addFaculty(Faculty any) {
        return facultyRepository.addFaculty(any);
    }

    @Override
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    @Override
    public Collection<Faculty> findByNameOrColorContainsIgnoreCase(String filter) {
        return List.of();
    }

    @Override
    public Optional<List<String>> findLongestFacultyNames() {
        return Optional.empty();
    }
}




