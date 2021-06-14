package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserBucketController {
    private final UserBucketRepository userBucketRepository;
    private final UserRepository userRepository;
    private final BucketRepository bucketRepository;
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

    @PostMapping("/register")
    public UserBucket register(@RequestBody Map<String, Integer> ids) throws ParseException {
        User user = userRepository.getById(ids.get("userID"));
        Bucket bucket = bucketRepository.getById(ids.get("bucketID"));
        UserBucket userBucket = UserBucket.builder().user(user).bucket(bucket).build();
        bucket.setCount(bucket.getCount()+1);
        System.out.println(userBucket);
        return userBucketRepository.save(userBucket);
    }
}
