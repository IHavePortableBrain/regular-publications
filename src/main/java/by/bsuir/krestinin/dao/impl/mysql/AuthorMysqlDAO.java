package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Author;

public class AuthorMysqlDAO implements AuthorDAO {
    @Override
    public void create(Author author) throws DAOException {


    }

    @Override
    public Author read(int authorId) throws DAOException {
        return null;
    }

    @Override
    public void update(Author author) throws DAOException {

    }

    @Override
    public void delete(int authorId) throws DAOException {

    }
}
