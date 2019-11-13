package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.dao.api.CRUD;
import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.validator.PublicationValidator;

public interface PublicationService extends CRUD<Publication> {
    PublicationValidator getValidator();

    PublicationDAO getDAO();
}
