package asistenciaalumnos.app.Dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> findAll();
    int insert(T t);
    int delete(Long t);
    int update(T t);
    T findOne(Long t);


}
