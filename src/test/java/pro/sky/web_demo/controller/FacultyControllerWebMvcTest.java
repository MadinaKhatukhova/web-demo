package pro.sky.web_demo.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.web_demo.exception.FacultyNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.service.FacultyService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class FacultyControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FacultyService facultyService;

    @Test
    public void getAllFaculties() throws Exception {
        List<Faculty> arrResult = new ArrayList<>();
        arrResult.add(new Faculty("Hufflepuff", "black"));
        arrResult.add(new Faculty("Slytherin", "silver"));
        when(facultyService.findAll()).thenReturn(arrResult);
        mockMvc.perform(MockMvcRequestBuilders.get("/faculty"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].name").value("Hufflepuff"))
                .andExpect(jsonPath("$[0].color").value("black"))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].name").value("Slytherin"))
                .andExpect(jsonPath("$[1].color").value("silver"))
                .andExpect(jsonPath("$[2]").doesNotExist());
    }

    @Test
    public void getAllFacultiesWhenFacultiesDoNotExist() throws Exception {
        when(facultyService.findAll()).thenThrow(new FacultyNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/faculty"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getFacultyById() throws Exception {
        when(facultyService.findFaculty(anyLong()))
                .thenReturn(new Faculty("Griffindor", "brown"));
        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name").value("Griffindor"))
                .andExpect(jsonPath("$.color").value("brown"));
    }

    @Test
    public void getFacultyByIdWhenFacultyDoesNotExist() throws Exception {
        when(facultyService.findFaculty(anyLong())).thenThrow(FacultyNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Raven claw");
        faculty.setColor("dark-blue");
        when(facultyService.addFaculty(any(Faculty.class))).thenReturn(faculty);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content((new ObjectMapper()).writeValueAsString(faculty)))
                .andDo(print());
    }

    @Test
    public void editFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Gryffindor");
        faculty.setColor("dark-red");
        when(facultyService.editFaculty(any(Faculty.class))).thenReturn(faculty);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content((new ObjectMapper()).writeValueAsString(faculty)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Gryffindor"))
                .andExpect(jsonPath("$.color").value("dark-red"));
    }
}