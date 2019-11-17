package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.exception.ServiceException;

public class AuthorMysqlDAO implements AuthorDAO {

    @Override
    public Publication[] readAll() throws DAOException {
        return new Publication[0];
    }

    @Override
    public void create(Publication publication) throws DAOException, ServiceException {

    }

    @Override
    public Publication read(int id) throws DAOException, ServiceException {
        return null;
    }

    @Override
    public void update(Publication publication) throws DAOException, ServiceException {

    }

    @Override
    public void delete(int id) throws DAOException, ServiceException {

    }
}
