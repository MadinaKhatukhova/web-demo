package pro.sky.web_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.web_demo.model.Faculty;

import java.util.Collection;
import java.util.List;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

    Collection<Faculty> getFilteredByColorOrName(String color, String name);

    Collection<Faculty> getAllFaculties();
}
