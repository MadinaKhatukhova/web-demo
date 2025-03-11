package pro.sky.web_demo.repository;


import pro.sky.web_demo.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCaseOrNameIgnoreCase(String color, String name);
}
