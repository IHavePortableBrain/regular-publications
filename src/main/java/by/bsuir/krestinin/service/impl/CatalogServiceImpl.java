package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.CatalogDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Catalog;
import by.bsuir.krestinin.service.api.CatalogService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.CatalogValidator;

public class CatalogServiceImpl implements CatalogService {
    private static final CatalogDAO catalogDAO = DAOFactory.getInstance().getCatalogDAO();

    @Override
    public void create(Catalog catalog) throws ServiceException {
        if (!CatalogValidator.isValidCatalog(catalog)) {
            throw new ServiceException("Invalid catalog: " + catalog);
        }

        try {
            catalogDAO.create(catalog);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Catalog read(int catalogId) throws ServiceException {
        if (!CatalogValidator.isValidId(catalogId)) {
            throw new ServiceException("Invalid catalog id: " + catalogId);
        }

        Catalog catalog;

        try {
            catalog = catalogDAO.read(catalogId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return catalog;
    }

    @Override
    public void update(Catalog catalog) throws ServiceException {
        if (!CatalogValidator.isValidCatalog(catalog)) {
            throw new ServiceException("Invalid catalog: " + catalog);
        }

        try {
            catalogDAO.update(catalog);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int catalogId) throws ServiceException {
        if (!CatalogValidator.isValidId(catalogId)) {
            throw new ServiceException("Invalid catalog id: " + catalogId);
        }

        try {
            catalogDAO.delete(catalogId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
