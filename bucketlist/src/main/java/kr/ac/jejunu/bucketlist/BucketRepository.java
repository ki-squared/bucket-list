package kr.ac.jejunu.bucketlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer> {
  List<Bucket> findAll();
}
