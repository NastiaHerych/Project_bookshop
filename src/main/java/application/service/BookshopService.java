package application.service;

import application.domain.Bookshop;
import org.springframework.stereotype.Service;
import application.realisationCRUD.realisationCRUD;

//@Service
public interface BookshopService extends realisationCRUD<Bookshop> {
    //public Map<Integer, Bookshop> readAllMap();
}
