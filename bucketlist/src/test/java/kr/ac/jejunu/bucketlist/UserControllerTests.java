package kr.ac.jejunu.bucketlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.type.TrueFalseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    private UserController userController;

    @Autowired
    private ObjectMapper objectMapper;

    public Integer id = 1;
    public String name = "testName";
    public String password = "testPassword";
    public String email = "test@email.com";

//    @Test
//    public void list() throws Exception {
//        List<User> users = new ArrayList<>();
//        Integer id = 1;
//        String name = "testName";
//        User user = User.builder().id(id).name(name).build();
//        users.add(user);
//        given(userController.list()).willReturn(users);
//        mvc.perform(get("/api/list"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].id", greaterThan(0)))
//                .andExpect(jsonPath("$[0].name", is(name)));
//    }

//    @Test
//    public void fetch() throws Exception {
//        User user = User.builder().id(id).name(name).password(password).build();
//        given(userController.fetch(email, password)).willReturn(user);
//        mvc.perform(get("/api/fetch"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void login() throws Exception {
        User user = User.builder().id(id).name(name).password(password).build();
        MockHttpServletRequest req = new MockHttpServletRequest();
        given(userController.login(email, password, req)).willReturn(user);
        String jsonString = objectMapper.writeValueAsString(user);
        mvc.perform(post("/api/loginCheck")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                    .andExpect(status().isOk());
    }
}
