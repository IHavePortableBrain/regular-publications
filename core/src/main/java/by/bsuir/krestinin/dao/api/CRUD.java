package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface CRUD<T> {
    void create(T publication) throws DAOException, ServiceException;

    T read(int id) throws DAOException, ServiceException;

    void update(T publication) throws DAOException, ServiceException;

    void delete(int id) throws DAOException, ServiceException;
}
