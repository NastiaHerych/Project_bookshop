package application.dao;

import application.domain.User;
import application.realisationCRUD.realisationCRUD;

public interface UserDAO extends realisationCRUD<User> {
    User getUserByEmail(String email);
}