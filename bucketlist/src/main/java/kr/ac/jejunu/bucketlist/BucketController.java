package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BucketController {
    private final BucketRepository bucketRepository;

    @GetMapping("/listAll")
    public List<Bucket> listAll() {
        return bucketRepository.findAll();
    }

    @PostMapping("/save")
    public Bucket create(@RequestBody Bucket bucket) {
        return bucketRepository.save(bucket);
    }
}
