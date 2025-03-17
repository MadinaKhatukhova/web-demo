import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.web_demo.controller.FacultyController;
import pro.sky.web_demo.exception.FacultyNotFoundException;
import pro.sky.web_demo.model.Faculty;
import pro.sky.web_demo.service.FacultyService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FacultyService facultyService;

    @Test
    public void testGetFacultyById() throws Exception{

        Faculty faculty = new Faculty("Griffindor", "Brown");
        when(facultyService.getFacultyById(anyLong())).thenReturn(faculty);

        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/faculties"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name").value("Griffindor"))
                .andExpect(jsonPath("$.color").value("Brown"));
    }


    @Test
    public void testGetFacultyByIdWhenFacultyNotExist() throws Exception{

        when(facultyService.getFacultyById(anyLong())).thenThrow(FacultyNotFoundException.class);

        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/faculties"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    public void testCreateFaculty() throws Exception{

        Faculty faculty = new Faculty("Griffindor", "Brown");
        when(facultyService.createFaculty(any(Faculty.class))).thenReturn(faculty);

        ObjectMapper objectMapper = new ObjectMapper();
        //Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/faculties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(faculty)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name").value("Griffindor"))
                .andExpect(jsonPath("$.color").value("Brown"));
    }

    @Test
    public void testDeleteFaculty() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/faculties/1"))

                .andDo(print())
                .andExpect(status().isOk());


}

}
