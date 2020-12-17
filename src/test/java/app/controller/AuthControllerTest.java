package app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAuthentication_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user12\",\"password\":\"pass12word\"}"))
        .andExpect(status().isOk());
    }

    @Test
    void testAuthentication_invalid_username() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"u#$dqe2\",\"password\":\"pass12word\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAuthentication_invalid_password() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user12\",\"password\":\"pass^@ord\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAuthentication_blank_username() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user12\",\"password\":\"pass^@ord\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAuthentication_blank_password() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user12\",\"password\":\"pass^@ord\"}"))
                .andExpect(status().isUnauthorized());
    }
}
