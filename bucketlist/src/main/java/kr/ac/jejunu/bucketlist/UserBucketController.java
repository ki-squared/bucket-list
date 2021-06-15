package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        Timestamp jdbcDueDate = new Timestamp(dueDate.getTime());

        userBucket.setDue_date(jdbcDueDate);
    }
}
