package kr.ac.jejunu.bucketlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    private UserController userController;

    public Integer id = 1;
    public String name = "testName";
    public String password = "testPassword";
    public String email = "test@email.com";

//    @Test
//    public void fetch() throws Exception {
//        User user = User.builder().id(id).name(name).password(password).build();
//        given(userController.fetch(email, password)).willReturn(user);
//        mvc.perform(get("/api/fetch"))
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void login() throws Exception {
//        User user = User.builder().id(id).name(name).password(password).build();
//        MockHttpServletRequest req = new MockHttpServletRequest();
//        String jsonString = objectMapper.writeValueAsString(user);
//        mvc.perform(post("/api/loginCheck")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString))
//                    .andExpect(status().isOk());
//    }
}
