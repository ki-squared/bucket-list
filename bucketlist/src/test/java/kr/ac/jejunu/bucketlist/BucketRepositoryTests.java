package kr.ac.jejunu.bucketlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@DataJpaTest
public class BucketRepositoryTests {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BucketRepository bucketRepository;

    @Test
    public void findAll() {
        Integer id = 1;
        String title = "과제 탈출!!";
        Bucket bucket = Bucket.builder().id(id).title(title).build();
        entityManager.persist(bucket);
        List<Bucket> buckets = bucketRepository.findAll();
        assertThat(buckets.get(0).getId(), is(id));
        assertThat(buckets.get(0).getTitle(), is(title));

    }
}
