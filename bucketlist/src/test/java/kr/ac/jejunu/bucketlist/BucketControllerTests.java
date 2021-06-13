package kr.ac.jejunu.bucketlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.ObjectEnumerableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class BucketControllerTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    private BucketController bucketController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void listAll() throws Exception {
        List<Bucket> buckets = new ArrayList<>();
        Integer id = 1;
        String title = "과제 탈출!";
        Bucket bucket = Bucket.builder().id(id).title(title).build();
        buckets.add(bucket);
        given(bucketController.listAll()).willReturn(buckets);
        mvc.perform(get("/api/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(title)))
                .andExpect(jsonPath("$[0].id", is(id)));
    }

    @Test
    public void create() throws Exception {
        String title = "종강하기";
        Integer count = 0;
        Bucket bucket = Bucket.builder().title(title).count(count).build();
        given(bucketController.create(bucket)).willReturn(bucket);
        String jsonString = objectMapper.writeValueAsString(bucket)
;        mvc.perform(post("/api/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }
}
