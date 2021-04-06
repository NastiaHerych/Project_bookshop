package application.mapper;


import application.domain.Bookshop;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookshopMapper {
    public static Bookshop map(ResultSet result) throws SQLException {

        String name = result.getString("name");
        String author = result.getString("author");
        String description = result.getString("description");
        Double price = result.getDouble("price");


        return new Bookshop(name, author, description, price);
    }
}