package pro.sky.web_demo.service;
import pro.sky.web_demo.model.Faculty;
import java.util.Collection;
import java.util.List;

public interface FacultyService {
    List<Faculty> findAll();

    Faculty findFaculty(Long id);

    void deleteFaculty(Long id);

    Faculty editFaculty(Faculty faculty);

    Faculty addFaculty(Faculty faculty);

    Collection<Faculty> findByColor(String color);

    Collection<Faculty> findByNameOrColorContainsIgnoreCase(String color, String name);


    // parallel streams

    String getLongestFacultyName();

    int getSum();
}
