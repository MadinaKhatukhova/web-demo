package pro.sky.web_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.web_demo.model.Faculty;

import java.util.Collection;
import java.util.List;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

    Collection<Faculty> getFilteredByColorOrName(String color, String name);

    Collection<Faculty> getAllFaculties();

    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty();

    Faculty getFaculty(Long id, Faculty faculty);

    Faculty updateFaculty(Long id, Faculty faculty);

    Faculty getFacultyById(Long id);

    Faculty findFaculty(Long id);

    Object editFaculty(Faculty any);

    Object addFaculty(Faculty any);

    Collection<Faculty> findByColor(String color);
}
