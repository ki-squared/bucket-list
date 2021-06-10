package kr.ac.jejunu.bucketlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mylist")
public class Bucket {
    @Id
    private String title;
    private String comment;
    private Date date;
    private Integer id;
}
