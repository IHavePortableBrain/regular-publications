package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.CatalogDAO;
import by.bsuir.krestinin.dao.factory.XmlDAOFactory;
import by.bsuir.krestinin.service.api.CatalogService;
import by.bsuir.krestinin.service.validator.CatalogValidator;

public class CatalogServiceImpl extends PublicationServiceImpl
        implements CatalogService {
    private static final CatalogDAO catalogDAO = XmlDAOFactory.getInstance().getCatalogDAO();
    private static final CatalogValidator catalogValidator = new CatalogValidator();

    @Override
    public CatalogValidator getValidator() {
        return catalogValidator;
    }

    @Override
    public CatalogDAO getDAO() {
        return catalogDAO;
    }
}
