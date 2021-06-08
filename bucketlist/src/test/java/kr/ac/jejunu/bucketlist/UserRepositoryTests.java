package kr.ac.jejunu.bucketlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void findAll() {
//        String name = "testName";
//        User user = User.builder().name(name).build();
//        entityManager.persist(user);
//        List<User> users = userRepository.findAll();
//        assertThat(users.get(0).getId(), greaterThan(0));
//        assertThat(users.get(0).getName(), is(name));
//    }

    @Test
    public void findByEmailAndPassword() {
        String name = "testName";
        String email = "test@email.com";
        String password = "testPassword";
        User user = User.builder().name(name).email(email).password(password).build();
        entityManager.persist(user);
        User fetchedUser = userRepository.findByEmailAndPassword(email, password);
        assertThat(fetchedUser.getId(), is(user.getId()));
        assertThat(fetchedUser.getName(), is(user.getName()));
        assertThat(fetchedUser.getEmail(), is(user.getEmail()));
        assertThat(fetchedUser.getPassword(), is(user.getPassword()));
    }
}
