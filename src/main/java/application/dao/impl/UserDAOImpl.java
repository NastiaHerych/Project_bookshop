package application.dao.impl;

import application.dao.UserDAO;
import application.domain.User;
import application.mapper.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import application.dbConnection.dbConnection;

//@Component
public class UserDAOImpl implements UserDAO {

    //private static String CREATE = "insert into user(first_name, last_name, age, address, user_email) value(?,?,?,?,?)";
    private static String CREATE = "insert into user(`firstName`, `lastName`, `password`, `email`, `phone_number`, `address`, `postal_code`) values (?,?,?,?,?,?,?)";
    private static String READ_BY_ID = "select * from user where id =?";
    private static String READ_BY_EMAIL = "select * from user where email=?";
    // private static String UPDATE_BY_ID = "update user set first_name=?, last_name =?, age =?, address =?, user_email =? where id =?";
    private static String UPDATE_BY_ID = "update user set firstName = ?, lastName = ?,  password =?, email=?, phone_number=?, address=?, postal_code=?  where id = ?";
    private static String DELETE_BY_ID = "delete from user where id =?";
    private static String READ_ALL = "select * from user";

    //private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);


    private Connection connection;
    private PreparedStatement preparedStatemant;

    public UserDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = dbConnection.openConnection();
    }

    //  @Override
    public User create(User user) {
        try {
            preparedStatemant = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatemant.setString(1, user.getEmail());
            preparedStatemant.setString(2, user.getFirstName());
            preparedStatemant.setString(3, user.getLastName());
            preparedStatemant.setString(4, user.getAddress());
            preparedStatemant.setString(5, user.getPassword());
            preparedStatemant.setInt(6, user.getId());
            preparedStatemant.setString(7, user.getPhone_number());
            preparedStatemant.setInt(8, user.getPostal_code());
            preparedStatemant.executeUpdate();

            ResultSet rs = preparedStatemant.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
        return user;
    }

    // @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatemant = connection.prepareStatement(READ_BY_ID);
            preparedStatemant.setInt(1, id);
            ResultSet result = preparedStatemant.executeQuery();
            result.next();
            // return UserMapper.map(result);
            Integer userId = result.getInt("id");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String password = result.getString("password");
            String email = result.getString("email");
            String phone_number = result.getString("phone_number");
            String address = result.getString("address");
            Integer postal_code = result.getInt("postal_code");


            user = new User(userId, firstName, lastName, password, email, phone_number, address, postal_code);


        } catch (SQLException e) {
            //LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User read_E(String email) {
        return null;
    }

    //  @Override
    public User update(User user) {
        try {
            preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatemant.setString(1, user.getEmail());
            preparedStatemant.setString(2, user.getFirstName());
            preparedStatemant.setString(3, user.getLastName());
            preparedStatemant.setString(4, user.getAddress());
            preparedStatemant.setString(5, user.getPassword());
            preparedStatemant.setInt(6, user.getId());
            preparedStatemant.setString(7, user.getPhone_number());
            preparedStatemant.setInt(8, user.getPostal_code());
            preparedStatemant.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
        return user;
    }

    //@Override
    public void delete(Integer id) {
        try {
            preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
            preparedStatemant.setInt(1, id);
            preparedStatemant.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
    }

    // @Override
    public List<User> readAll() {
        List<User> listOfUser = new ArrayList<User>();

        try {
            preparedStatemant = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatemant.executeQuery();
            while (result.next()) {
                //listOfUser.add(UserMapper.map(result));
                Integer userId = result.getInt("id");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String password = result.getString("password");
                String email = result.getString("email");
                String phone_number = result.getString("phone_number");
                String address = result.getString("address");
                Integer postal_code = result.getInt("postal_code");


                listOfUser.add(new User(userId, firstName, lastName, password, email, phone_number, address, postal_code));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
        return listOfUser;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer userId = result.getInt("id");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String password = result.getString("password");
            String phone_number = result.getString("phone_number");
            String address = result.getString("address");
            Integer postal_code = result.getInt("postal_code");


            user = new User(userId, firstName, lastName, password, email, phone_number, address, postal_code);

        } catch (SQLException e) {
            // LOGGER.error(e);

        }

        return user;

    }


}