package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.service.api.AuthorService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.AuthorValidator;

public class AuthorServiceImpl implements AuthorService {
    private static final AuthorDAO authorDAO = DAOFactory.getInstance().getAuthorDAO();

    @Override
    public void create(Author author) throws ServiceException {
        if (!AuthorValidator.isValidAuthor(author)) {
            throw new ServiceException("Invalid author: " + author.toString());
        }

        try {
            authorDAO.create(author);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Author read(int authorId) throws ServiceException {
        if (!AuthorValidator.isValidId(authorId)) {
            throw new ServiceException("Invalid author id: " + authorId);
        }

        Author author;

        try {
            author = authorDAO.read(authorId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return author;
    }

    @Override
    public void update(Author author) throws ServiceException {
        if (!AuthorValidator.isValidAuthor(author)) {
            throw new ServiceException("Invalid author: " + author);
        }

        try {
            authorDAO.update(author);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int authorId) throws ServiceException {
        if (!AuthorValidator.isValidId(authorId)) {
            throw new ServiceException("Invalid author id: " + authorId);
        }

        try {
            authorDAO.delete(authorId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
