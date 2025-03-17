import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pro.sky.web_demo.model.Faculty;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetFacultyId(){

        //Arrange
        Faculty newFaculty = testRestTemplate.postForEntity("http://localhost:"+port+"faculties", new Faculty("Griffindor", "Brown"), Faculty.class).getBody();


        //Act
        ResponseEntity<Faculty> facultyResponseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"faculties/"+newFaculty.getId(), Faculty.class);

        //Assert
        assertThat(facultyResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Faculty faculty = facultyResponseEntity.getBody();
        assertThat(faculty.getColor()).isEqualTo("Brown");
        assertThat(faculty.getName()).isEqualTo("Griffindor");
    }


}
