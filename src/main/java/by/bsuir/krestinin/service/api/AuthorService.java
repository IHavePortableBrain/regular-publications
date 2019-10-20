package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface AuthorService {
    void create(Author author) throws ServiceException;

    Author read(int authorId) throws ServiceException;

    void update(Author author) throws ServiceException;

    void delete(int authorId) throws ServiceException;
}
