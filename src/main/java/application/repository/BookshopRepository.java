package application.repository;

import application.domain.Bookshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshopRepository extends CrudRepository <Bookshop, Integer> {
}
