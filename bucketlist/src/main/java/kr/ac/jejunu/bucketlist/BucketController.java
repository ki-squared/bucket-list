package kr.ac.jejunu.bucketlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BucketController {
    private final BucketRepository bucketRepository;

    @GetMapping("/getBucket/{bucketID}")
    public Bucket getBucket(@PathVariable Integer bucketID) {
        return bucketRepository.findById(bucketID).get();
    }

    @GetMapping("/listAll")
    public List<Bucket> listAll() {
        return bucketRepository.findAll();
    }

    @PostMapping("/save")
    public Bucket create(@RequestBody Bucket bucket) {
        return bucketRepository.save(bucket);
    }
}
