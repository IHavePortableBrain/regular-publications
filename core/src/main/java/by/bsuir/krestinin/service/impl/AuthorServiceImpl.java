package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.dao.factory.XmlDAOFactory;
import by.bsuir.krestinin.service.api.AuthorService;
import by.bsuir.krestinin.service.validator.AuthorValidator;

public class AuthorServiceImpl extends PublicationServiceImpl
        implements AuthorService {
    private static final AuthorDAO authorDAO = XmlDAOFactory.getInstance().getAuthorDAO();
    private static final AuthorValidator authorValidator = new AuthorValidator();

    @Override
    public AuthorValidator getValidator() {
        return authorValidator;
    }

    @Override
    public AuthorDAO getDAO() {
        return authorDAO;
    }
}
