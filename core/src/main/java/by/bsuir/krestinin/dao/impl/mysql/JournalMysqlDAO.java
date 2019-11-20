package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.JournalDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Journal;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class JournalMysqlDAO  extends PublicationMysqlDAO implements JournalDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);

        Journal JournalEntity = (Journal)entity;
        Journal JournalUpdate = (Journal)update;

        JournalEntity.setAuthors(JournalUpdate.getAuthors());
        JournalEntity.setJournalType(JournalUpdate.getJournalType());

        return entity;
    }
}