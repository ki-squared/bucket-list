package kr.ac.jejunu.bucketlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="userbucketlist")
public class UserBucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String review;
    private Date dueDate;
    private Date finishedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Bucket bucket;
}
