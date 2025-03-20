package pro.sky.web_demo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pro.sky.web_demo.model.Student;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    void getAllStudents() {
        Assertions
                .assertThat(restTemplate.getForObject("http://localhost:" + port, String.class))
                .isNotNull();
    }

    @Test
    void getStudentById() {
        Assertions
                .assertThat(restTemplate.getForObject("http://localhost:" + port + "/1", String.class))
                .isNotNull();
    }

    @Test
    void createStudent() {
        Assertions
                .assertThat(restTemplate.postForObject("http://localhost:" + port,
                        new Student("John Lennon", 30),
                        String.class))
                .isNotNull();
    }

    @Test
    void editStudent() {
        final ResponseEntity<Student> response = restTemplate.exchange("http://localhost:" + port,
                HttpMethod.PUT,
                new HttpEntity<>(new Student("John Lennon", 30)),
                Student.class);
        Assertions.assertThat(response.getStatusCode()).isNotNull();
    }

    @Test
    void deleteStudent() {
        final ResponseEntity<Void> response = restTemplate.exchange("http://localhost:" + port + "/1",
                HttpMethod.DELETE,
                new HttpEntity<>(null),
                Void.class);
        Assertions.assertThat(response.getStatusCode()).isNotNull();
    }
}