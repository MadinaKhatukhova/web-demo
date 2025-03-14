package pro.sky.web_demo.service;

import pro.sky.web_demo.model.Faculty;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty();

    Faculty getFaculty(Long id, Faculty faculty);

    Faculty updateFaculty(Long id, Faculty faculty);

    void removeFaculty(Long id);


}
