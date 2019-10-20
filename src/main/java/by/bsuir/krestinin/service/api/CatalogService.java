package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Catalog;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface CatalogService {
    void create(Catalog catalog) throws ServiceException;

    Catalog read(int catalogId) throws ServiceException;

    void update(Catalog catalog) throws ServiceException;

    void delete(int catalogId) throws ServiceException;
}
