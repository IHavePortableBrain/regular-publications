package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.EventDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Event;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class EventMysqlDAO extends PublicationMysqlDAO implements EventDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);

        Event EventEntity = (Event)entity;
        Event EventUpdate = (Event)update;

        EventEntity.setDescription(EventUpdate.getDescription());
        EventEntity.setAmountOfPeopleActed(EventUpdate.getAmountOfPeopleActed());
        EventEntity.setDateHappened(EventUpdate.getDateHappened());
        EventEntity.setPublishingPlaces(EventUpdate.getPublishingPlaces());

        return entity;
    }
}
