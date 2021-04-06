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
    private static String CREATE = "insert into user(`email`,`first_name`, `last_name`, `role`, `password`) values (?,?,?,?,?)";
    private static String READ_BY_ID = "select * from user where id =?";
    private static String READ_BY_EMAIL = "select * from user where email=?";
    // private static String UPDATE_BY_ID = "update user set first_name=?, last_name =?, age =?, address =?, user_email =? where id =?";
    private static String UPDATE_BY_ID = "update user set email=?, first_name = ?, last_name = ?, role=?, password =?  where id = ?";
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
            preparedStatemant.setString(4,  user.getRole());
            preparedStatemant.setString(5, user.getPassword());
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
            String email = result.getString("email");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String role = result.getString("role");
            String password = result.getString("password");
            user = new User(userId, email, firstName, lastName, role, password);


        } catch (SQLException e) {
            //LOGGER.error(e);
        }
        return user;
    }

    //  @Override
    public User update(User user) {
        try {
            preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatemant.setString(1, user.getEmail());
            preparedStatemant.setString(2, user.getFirstName());
            preparedStatemant.setString(3, user.getLastName());
            preparedStatemant.setString(4, user.getRole());
            preparedStatemant.setString(5, user.getPassword());
            preparedStatemant.setInt(6, user.getId());
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
                String email = result.getString("email");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String role = result.getString("role");
                String password = result.getString("password");
                listOfUser.add(new User(userId, email, firstName, lastName, role, password));
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
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String role = result.getString("role");
            String password = result.getString("password");
            user = new User(userId, email, firstName, lastName, role, password);

        } catch (SQLException e) {
            // LOGGER.error(e);

        }

        return user;

    }


}