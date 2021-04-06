package application.dao.impl;

import application.dbConnection.dbConnection;
import application.domain.Bookshop;
import application.domain.User;
import application.mapper.BookshopMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookshopDAOImpl {
    private Connection connection;
    private PreparedStatement preparedStatemant;

    private static String CREATE = "insert into bookshop(book_name, book_author, book_price, quantity) value(?,?,?,?)";
    private static String READ_BY_ID = "select * from bookshop where id =?";
    private static String UPDATE_BY_ID = "update user set book_name=?, book_author =?, book_price =?, quantity =? where id =?";
    private static String DELETE_BY_ID = "delete from bookshop where id =?";
    private static String READ_ALL = "select * from bookshop";

    public BookshopDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = dbConnection.openConnection();
    }

//    public Bookshop create(Bookshop bookshop) {
//        try {
//            preparedStatemant = connection.prepareStatement(CREATE);
//            preparedStatemant.setString(1, bookshop.getBookName());
//            preparedStatemant.setString(2, bookshop.getBookAuthor());
//            preparedStatemant.setDouble(3, bookshop.getBookPrice());
//            preparedStatemant.setInt(4, bookshop.getQuantity());
//            preparedStatemant.executeUpdate();
//            ResultSet rs = preparedStatemant.getGeneratedKeys();
//            rs.next();
//            bookshop.setId(rs.getInt(1));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookshop;
//    }


    public Bookshop read(Integer id) {
        Bookshop book = null;
        try {
            preparedStatemant = connection.prepareStatement(READ_BY_ID);
            preparedStatemant.setInt(1, id);
            ResultSet result = preparedStatemant.executeQuery();
            result.next();
            return BookshopMapper.map(result);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return book;
    }

//    public Bookshop update(Bookshop bookshop) {
//        try {
//            preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
//            preparedStatemant.setString(1, bookshop.getBookName());
//            preparedStatemant.setString(2, bookshop.getBookAuthor());
//            preparedStatemant.setDouble(3, bookshop.getBookPrice());
//            preparedStatemant.setInt(4, bookshop.getQuantity());
//            preparedStatemant.setInt(5, bookshop.getId());
//            preparedStatemant.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookshop;
//    }

    public void delete(Integer id) {
        try {
            preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
            preparedStatemant.setInt(1, id);
            preparedStatemant.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Bookshop> readAll() {
        List<Bookshop> listOfUser = new ArrayList<>();

        try {
            preparedStatemant = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatemant.executeQuery();
            while (result.next()) {
                listOfUser.add(BookshopMapper.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUser;
    }



}