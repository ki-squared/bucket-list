package kr.ac.jejunu.bucketlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBucketRepository extends JpaRepository<UserBucket, Integer> {
}
