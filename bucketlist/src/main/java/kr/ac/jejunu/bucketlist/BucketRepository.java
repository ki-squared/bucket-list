package kr.ac.jejunu.bucketlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer> {
  @Query("select list from mylist list where list.id=?1")
  List<Bucket> findListById(Integer id);
}
