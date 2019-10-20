package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Catalog;

public interface CatalogDAO {
    void create(Catalog catalog) throws DAOException;

    Catalog read(int catalogId) throws DAOException;

    void update(Catalog catalog) throws DAOException;

    void delete(int catalogId) throws DAOException;
}
