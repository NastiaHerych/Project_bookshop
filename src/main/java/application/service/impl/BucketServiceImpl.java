package application.service.impl;

import application.dao.BucketDAO;
import application.dao.impl.BucketDAOImpl;
import application.domain.Bucket;
import application.domain.User;
import application.service.BucketService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {
     private static BucketService bucketServiceImpl;
    private BucketDAO bucketDao;

    private BucketServiceImpl() {
        try {
            bucketDao = new BucketDAOImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
           // LOGGER.error(e);
        }
    }

    public static BucketService getBucketService() {
        if (bucketServiceImpl == null) {
            bucketServiceImpl = new BucketServiceImpl();
        }
        return bucketServiceImpl;
    }

   @Override
    public Bucket create(Bucket t) {
        return bucketDao.create(t);
    }

   @Override
    public Bucket read(Integer id) {
        return bucketDao.read(id);
    }

    @Override
    public Bucket read_E(String email) {
        return null;
    }

//    @Override
//    public Bucket read_E(String email) {
//        return bucketDao.getUserByEmail(email);
//    }

   @Override
    public Bucket update(Bucket t) {
        return bucketDao.update(t);
    }


   @Override
    public void delete(Integer id) {
       bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }
}
