package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;

public interface CRUD<T> {
    void create(T publication) throws DAOException;

    T read(int id) throws DAOException;

    void update(T publication) throws DAOException;

    void delete(int id) throws DAOException;
}
