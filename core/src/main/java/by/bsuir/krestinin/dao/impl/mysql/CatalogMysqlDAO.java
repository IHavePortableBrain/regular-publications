package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.CatalogDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Catalog;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class CatalogMysqlDAO extends PublicationMysqlDAO implements CatalogDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);

        Catalog CatalogEntity = (Catalog)entity;
        Catalog CatalogUpdate = (Catalog)update;

        CatalogEntity.setPrice(CatalogUpdate.getPrice());
        CatalogEntity.setAmountOfItems(CatalogUpdate.getAmountOfItems());
        CatalogEntity.setShortDescription(CatalogUpdate.getShortDescription());

        return entity;
    }
}
