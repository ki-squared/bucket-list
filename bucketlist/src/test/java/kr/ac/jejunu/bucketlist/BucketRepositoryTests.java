package kr.ac.jejunu.bucketlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

@DataJpaTest
public class BucketRepositoryTests {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BucketRepository bucketRepository;

    String title = "잠자기";
    Integer count = 0;

    @Test
    public void findAll() {
        Bucket bucket = Bucket.builder().title(title).count(count).build();
        entityManager.persist(bucket);
        List<Bucket> buckets = bucketRepository.findAll();
        assertThat(buckets.get(0).getId(), greaterThan(0));
        assertThat(buckets.get(0).getTitle(), is(title));
    }

    @Test
    public void save() {
        Bucket bucket = Bucket.builder().title(title).count(count).build();
        bucket = bucketRepository.save(bucket);
        assertThat(bucket.getId(), greaterThan(0));
        assertThat(bucket.getTitle(), is(title));
        assertThat(bucket.getCount(), is(count));
    }

}
