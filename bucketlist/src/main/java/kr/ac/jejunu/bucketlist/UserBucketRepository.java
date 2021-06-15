package kr.ac.jejunu.bucketlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBucketRepository extends JpaRepository<UserBucket, Integer> {
    List findByUser_Id(Integer userID);
}
