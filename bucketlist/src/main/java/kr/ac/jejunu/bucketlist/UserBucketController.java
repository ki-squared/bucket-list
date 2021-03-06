package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserBucketController {
    private final UserBucketRepository userBucketRepository;
    private final UserRepository userRepository;
    private final BucketRepository bucketRepository;

    @PostMapping("/register")
    public UserBucket register(@RequestBody Map<String, Integer> ids) {
        User user = userRepository.getById(ids.get("userID"));
        Bucket bucket = bucketRepository.getById(ids.get("bucketID"));
        UserBucket userBucket = UserBucket.builder().user(user).bucket(bucket).title(bucket.getTitle()).build();
        bucket.setCount(bucket.getCount()+1);
        return userBucketRepository.save(userBucket);
    }

    @GetMapping("/list/{userID}")
    public List<UserBucket> bucketList(@PathVariable Integer userID) {
        return userBucketRepository.findByUser_Id(userID);
    }

    @PostMapping("/setDueDate")
    public void setDueDate(@RequestBody Map<String, String> dueInfos) throws ParseException {
        UserBucket userBucket = userBucketRepository.getById(Integer.parseInt(dueInfos.get("userBucketID")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = dueInfos.get("dueDate");
        Date dueDate = new Date(sdf.parse(date).getTime());
        userBucket.setDue_date(dueDate);
        userBucketRepository.save(userBucket);
    }

    @PostMapping("/setComplete")
    public void setCompletedBucket(@RequestBody Map<String, String> reviewInfos) {
        UserBucket userBucket = userBucketRepository.getById(Integer.parseInt(reviewInfos.get("userBucketID")));
        String review = reviewInfos.get("review");
        Date finishedDate = new Date(System.currentTimeMillis());
        userBucket.setReview(review);
        userBucket.setFinished_date(finishedDate);
        userBucketRepository.save(userBucket);
    }

    @DeleteMapping("/{userbucketID}")
    public void delete(@PathVariable Integer userbucketID) {
        UserBucket userBucket = userBucketRepository.findById(userbucketID).get();
        Bucket bucket = userBucket.getBucket();
        bucket.setCount(bucket.getCount()-1);
//        bucket.setCount((int)userBucketRepository.countByTitle(bucket.getTitle()));
        userBucketRepository.delete(userBucket);
    }
}
