package application.mapper;

import application.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User map(ResultSet result) throws SQLException {

        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        // int age = result.getInt("age");
        String role = result.getString("role");
        String email = result.getString("user_email");
        String password = result.getString("password");

        return new User(firstName, lastName,  role, email, password);
    }
}