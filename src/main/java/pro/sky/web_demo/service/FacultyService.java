package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty();

    Faculty getFaculty(Long id, Faculty faculty);

    Faculty updateFaculty(Long id, Faculty faculty);

    void removeFaculty(Long id);


    Object getFacultyById(Long id);

    Collection<Faculty> getFilteredByColorOrName(String color, String name);

    Collection<Faculty> getAllFaculties();

    Faculty findFaculty(Long id);
}
