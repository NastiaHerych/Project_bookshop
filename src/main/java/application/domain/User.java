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
public class User {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
   // private Integer age;
 //   private String address;
  //  private String userEmail;
    private String email;
    private String role;
    private String password;

//    public User(String firstName, String lastName, Integer age, String address, String userEmail) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.address = address;
//        this.userEmail = userEmail;
//    }

    public User(String email, String firstName, String lastName, String role, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.password = password;
    }
}
