package application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bookshop {
    @Id
    private Integer id;
//    private String bookName;
//    private String bookAuthor;
//    private Double bookPrice;
//    private Integer quantity;
    private String name;
    private String author;
    private String description;
    private Double price;

    public Bookshop(String name, String author, String description, Double price) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
    }

}
