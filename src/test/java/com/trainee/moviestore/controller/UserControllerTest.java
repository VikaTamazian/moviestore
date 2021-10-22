package com.trainee.moviestore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainee.moviestore.model.User;
import com.trainee.moviestore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        User user = new User();
        user.setUsername("NewUser");
        user.setPassword("User_Password");
        user.setEmail("user@mail.com");

        when(userService.findById(anyLong())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("NewUser"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("User_Password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("user@mail.com"))
                .andExpect(status().isOk());
    }

    @Test
    public void createUserTest() throws Exception {

        User user = new User();
        user.setId(1l);
        user.setUsername("NewUser");
        user.setPassword("User_Password");
        user.setEmail("user@mail.com");

        when(userService.create(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(new ObjectMapper().writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("NewUser"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("User_Password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("user@mail.com"));
    }
}
