package pro.sky.web_demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.web_demo.exception.FacultyNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.repository.FacultyRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public abstract class FacultyServiceImpl implements FacultyService {

    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    @Autowired
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
        return facultyRepository.save(getFaculty());
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
    public Collection<Faculty> getFilteredByColorOrName(String color, String name) {
        return List.of();
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return List.of();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException());
    }


    public Faculty addFaculty(Faculty faculty) {
        logger.info("addFaculty method has been invoked");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("findFaculty method has been invoked");
        logger.debug("Requesting info for faculty with id: {}, id");
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("editFaculty method has been invoked");
        logger.error("There is no faculty with id");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("deleteFaculty method has been invoked");
        facultyRepository.deleteById(id);
    }

    public List<Faculty> facultyColor(String color) {
        logger.info("facultyColor method has been invoked");
        return facultyRepository.findAll().stream().filter
                (faculty -> faculty.getColor().equals(color)).collect(Collectors.toList());
    }

    public Faculty findFacultyByNameOrColor(String name, String color) {
        logger.info("findFacultyByNameColor method has been invoked");
        return facultyRepository.findFacultyByNameOrColor(name, color);
    }

    public Optional<Faculty> findByFacultyId(Long facultyId) {
        logger.info("findByFacultyId method has been invoked");
        return facultyRepository.findById(facultyId);
    }
}







