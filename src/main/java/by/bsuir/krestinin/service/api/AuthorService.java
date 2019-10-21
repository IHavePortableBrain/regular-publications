package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.service.exception.ServiceException;

/**
 * Service class to operate with {@code Author} objects
 *
 * @author Vladislav Krestinin
 * @see Author
 */
public interface AuthorService {
    /**
     * Saves author to datasource
     *
     * @param author object to save
     * @throws ServiceException when given author has invalid data
     */
    void create(Author author) throws ServiceException;

    /**
     * Reads author with given id
     *
     * @param authorId to find by
     * @return found author
     * @throws ServiceException when given id isn't valid
     */
    Author read(int authorId) throws ServiceException;

    /**
     * Updates already existing author by newer
     * @param author object to replace older
     * @throws ServiceException when given author isn't valid
     */
    void update(Author author) throws ServiceException;

    /**
     * Deletes author from datasource
     *
     * @param authorId author to delete
     * @throws ServiceException when given author data is invalid
     */
    void delete(int authorId) throws ServiceException;
}
