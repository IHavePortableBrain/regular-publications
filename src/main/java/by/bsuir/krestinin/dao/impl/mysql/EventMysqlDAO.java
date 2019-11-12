package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.EventDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Event;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class EventMysqlDAO implements EventDAO {
    @Override
    public void create(Event event) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(event);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new DAOException(e);
        }
    }

    @Override
    public Event read(int eventId) throws DAOException {
        Transaction transaction = null;

        Event result;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.get(Event.class, eventId);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new DAOException(e);
        }

        return result;
    }

    @Override
    public void update(Event event) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Event result = session.get(Event.class, event.getId());
            result.setAmountOfPeopleActed(event.getAmountOfPeopleActed());
            result.setDateHappened(event.getDateHappened());
            result.setDescription(event.getDescription());
            result.setPublishingPlaces(event.getPublishingPlaces());

            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new DAOException(e);
        }
    }

    @Override
    public void delete(int eventId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Event result = session.get(Event.class, eventId);
            session.delete(result);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new DAOException(e);
        }
    }
}
