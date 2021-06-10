package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BucketController {
    private final BucketRepository bucketRepository;
    @GetMapping("/list")
    public List<Bucket> list(HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        return bucketRepository.findListById(user.getId());
    }
}
