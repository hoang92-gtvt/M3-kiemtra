package service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IService<E> {
    ArrayList<E> findAll() throws SQLException;
    void create(E newE);
    void edit(int index, E newE);
    void delete(int index);
    E getObjectById(int id);
}
