package application.service;

import application.domain.User;
import application.realisationCRUD.realisationCRUD;


public interface UserService extends realisationCRUD<User> {
   User read_E(String email);
}
