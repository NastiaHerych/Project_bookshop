package application.dao.impl;

import application.dao.BucketDAO;
import application.domain.Bucket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.dbConnection.dbConnection;


public class BucketDAOImpl implements BucketDAO {

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(user_id, book_id, date) value(?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String DELETE_BY_ID = "delete from bucket where id =?";

    private Connection connection;
    private PreparedStatement preparedStatemant;


    public BucketDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = dbConnection.openConnection();
    }

    //    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatemant = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatemant.setInt(1, bucket.getUserId());
            preparedStatemant.setInt(2, bucket.getBookId());
            preparedStatemant.setDate(3, (java.sql.Date) new Date(bucket.getDate().getTime()));
            preparedStatemant.executeUpdate();

            ResultSet rs = preparedStatemant.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));

        } catch (SQLException e) {
            // LOGGER.error(e);
        }
        return bucket;
    }

    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatemant = connection.prepareStatement(READ_BY_ID);
            preparedStatemant.setInt(1, id);
            ResultSet result = preparedStatemant.executeQuery();
            result.next();
            //return BucketMapper.map(result);

            Integer bucketId = result.getInt("id");
            Integer userId = result.getInt("user_id");
            Integer bookId = result.getInt("book_id");
            java.util.Date date = result.getDate("date");

            bucket = new Bucket(bucketId, userId, bookId, date);

        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
        return bucket;
    }

    @Override
    public Bucket read_E(String email) {
        return null;
    }


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

    public Bucket update(Bucket t){
        throw new IllegalStateException("no update for bucket");
    }

    public List<Bucket> readAll() {
        List<Bucket> listOfBucket = new ArrayList<Bucket>();

        try {
            preparedStatemant = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatemant.executeQuery();
            while (result.next()) {
                //listOfBucket.add(BucketMapper.map(result));
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("user_id");
                Integer bookId = result.getInt("book_id");
                java.util.Date date = result.getDate("date");
                listOfBucket.add(new Bucket(bucketId, userId, bookId, date));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // LOGGER.error(e);
        }
        return listOfBucket;
    }


}