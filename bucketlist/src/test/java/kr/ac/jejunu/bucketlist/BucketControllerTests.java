package kr.ac.jejunu.bucketlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @Test
    public void list() throws Exception {
        List<Bucket> buckets = new ArrayList<>();
        Integer id = 1;
        String title = "과제 탈출!";
        Bucket bucket = Bucket.builder().id(id).title(title).build();
        buckets.add(bucket);
//        given(bucketController.list()).willReturn(buckets);
        mvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(title)))
                .andExpect(jsonPath("$[0].id", is(id)));
    }
}
