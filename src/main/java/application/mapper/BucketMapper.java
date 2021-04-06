package application.mapper;

import application.domain.Bucket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BucketMapper {
    public static Bucket map(ResultSet result) throws SQLException {

        Integer bucketId = result.getInt("id");
        Integer userId = result.getInt("user_id");
        Integer bookId = result.getInt("book_id");
        java.util.Date date = result.getDate("date");

        return new Bucket(bucketId, userId, bookId, date);
    }
}