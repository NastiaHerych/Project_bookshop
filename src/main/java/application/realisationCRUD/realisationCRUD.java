package application.realisationCRUD;

import java.util.List;

public interface realisationCRUD<T> {
    T create(T t);
    T read(Integer id);
    T update(T t);
    void delete(Integer id);
    List<T> readAll();
}
