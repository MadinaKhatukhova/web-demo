package pro.sky.web_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.web_demo.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
