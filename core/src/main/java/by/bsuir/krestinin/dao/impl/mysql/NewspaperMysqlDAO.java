package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.validator.PublicationValidator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;


public class NewspaperMysqlDAO extends PublicationMysqlDAO implements NewspaperDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);
        Newspaper NewspaperEntity = (Newspaper)entity;
        Newspaper NewspaperUpdate = (Newspaper)update;

        NewspaperEntity.setEventsDescribed(NewspaperUpdate.getEventsDescribed());
        NewspaperEntity.setPages(NewspaperUpdate.getPages());


        return entity;
    }
}
