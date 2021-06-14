package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserBucketController {
    private final UserBucketRepository userBucketRepository;

    @PostMapping("/register")
    public UserBucket create(@RequestBody Bucket bucket, HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        UserBucket userBucket = UserBucket.builder().user(user).bucket(bucket).build();
        return userBucketRepository.save(userBucket);
    }
}
