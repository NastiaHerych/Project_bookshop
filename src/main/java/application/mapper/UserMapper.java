package application.mapper;

import application.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User map(ResultSet result) throws SQLException {

        String firstName = result.getString("firstName");
        String lastName = result.getString("lastName");
        String password = result.getString("password");
        String email = result.getString("email");
        String phone_number = result.getString("phone_number");
        String address = result.getString("address");
        Integer postal_code = result.getInt("postal_code");


        return new User(firstName, lastName, password, email, phone_number, address, postal_code);
    }
}