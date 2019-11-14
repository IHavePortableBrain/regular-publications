package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.dao.api.CRUD;
import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.PublicationValidator;

import java.util.List;

public interface PublicationService extends CRUD<Publication> {
    Publication[] readAll() throws ServiceException;

    List<Publication> sortByID(List<Publication> toSort) throws ServiceException;

    List<Publication> sortByPublicationDate(List<Publication> toSort) throws ServiceException;

    PublicationValidator getValidator();

    PublicationDAO getDAO();
}
