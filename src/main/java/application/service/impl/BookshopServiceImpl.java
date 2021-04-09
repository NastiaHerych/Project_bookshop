package application.service.impl;

import application.dao.BookshopDAO;
import application.domain.Bookshop;
import application.service.BookshopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshopServiceImpl implements BookshopService {
   // @Autowired
    private BookshopDAO bookshopDAO;

    @Override
    public Bookshop create(Bookshop t) {
        return bookshopDAO.create(t);
    }

   @Override
    public Bookshop read(Integer id) {
        return bookshopDAO.read(id);
    }

    @Override
    public Bookshop read_E(String email) {
        return null;
    }

    @Override
    public Bookshop update(Bookshop t) {
        return bookshopDAO.update(t);
    }

   @Override
    public void delete(Integer id) {
        bookshopDAO.delete(id);
    }

   @Override
    public List<Bookshop> readAll() {
        return bookshopDAO.readAll();
    }

}
