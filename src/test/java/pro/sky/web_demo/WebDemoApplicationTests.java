package pro.sky.web_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebDemoApplicationTests {


    @Test
    public void main() {
        SpringApplication.run(WebDemoApplication.class);
    }
}