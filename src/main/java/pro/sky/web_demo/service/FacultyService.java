package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Faculty;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> findAll();

    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty();

    Faculty getFaculty(Long id, Faculty faculty);

    Faculty updateFaculty(Long id, Faculty faculty);

    void removeFaculty(Long id);


    Faculty getFacultyById(Long id);

    Collection<Faculty> getFilteredByColorOrName(String color, String name);

    Collection<Faculty> getAllFaculties();

    Faculty findFaculty(Long id);

    void deleteFaculty(Long id);

    Object editFaculty(Faculty any);

    Object addFaculty(Faculty any);

    Collection<Faculty> findByColor(String color);

    Collection<Faculty> findByNameOrColorContainsIgnoreCase(String filter);

    Optional<List<String>> findLongestFacultyNames();
}
