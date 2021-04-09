package application.service;

import application.domain.User;
import application.realisationCRUD.realisationCRUD;


public interface UserService extends realisationCRUD<User> {
   // User getUserByEmail(String email);

   User read_E(String email);
}
