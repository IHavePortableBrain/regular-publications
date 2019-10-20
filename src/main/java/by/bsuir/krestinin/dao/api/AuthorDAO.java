package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Author;

public interface AuthorDAO {
    void create(Author author) throws DAOException;

    Author read(int authorId) throws DAOException;

    void update(Author author) throws DAOException;

    void delete(int authorId) throws DAOException;
}
