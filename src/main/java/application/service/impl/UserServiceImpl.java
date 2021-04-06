package application.service.impl;

import application.dao.UserDAO;
import application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import application.repository.UserRepository;
import application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static UserService userServiceImpl;
    private UserDAO userDao;
    @Autowired
    private UserRepository userRepository;

  public  UserServiceImpl() {
//        userDao = new UserDAOImpl();
    }

    @Override
    public User create(User t) {
        return userDao.create(t);
    }

  @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

   @Override
    public User update(User t) {
        return userDao.update(t);
    }

   @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

   @Override
    public List<User> readAll() {
        return (List<User>) userRepository.findAll();
    }
}
