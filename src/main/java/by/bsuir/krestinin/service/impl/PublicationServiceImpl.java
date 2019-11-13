package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.api.PublicationService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.PublicationValidator;

public abstract class PublicationServiceImpl implements PublicationService {
    public abstract PublicationValidator getValidator();

    public abstract PublicationDAO getDAO();

    @Override
    public void create(Publication publication) throws ServiceException {
        if (!getValidator().isValid(publication)) {
            throw new ServiceException("Invalid " + publication.getClass() + ":" + publication);
        }

        try {
            getDAO().create(publication);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Publication read(int publicationId) throws ServiceException {
        if (!getValidator().isValidId(publicationId)) {
            throw new ServiceException("Invalid publication id: " + publicationId);
        }

        Publication publication;

        try {
            publication = getDAO().read(publicationId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return publication;
    }

    @Override
    public void update(Publication publication) throws ServiceException {
        if (!getValidator().isValid(publication)) {
            throw new ServiceException("Invalid " + publication.getClass() + ": " + publication);
        }

        try {
            getDAO().update(publication);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int publicationId) throws ServiceException {
        if (!getValidator().isValidId(publicationId)) {
            throw new ServiceException("Invalid publication id: " + publicationId);
        }

        try {
            getDAO().delete(publicationId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
