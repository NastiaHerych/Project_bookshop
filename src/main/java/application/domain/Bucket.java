package application.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bucket {
    @Id
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date date;

    public Bucket(Integer userId, Integer bookId, Date date) {
        super();
        this.userId = userId;
        this.bookId = bookId;
        this.date = date;
    }
}
