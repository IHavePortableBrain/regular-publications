package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.CalendarDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class CalendarMysqlDAO implements CalendarDAO {
    @Override
    public void create(Publication calendar) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(calendar);

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
    public Calendar read(int calendarId) throws DAOException {
        Transaction transaction = null;

        Calendar result;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.get(Calendar.class, calendarId);

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
    public void update(Publication publication) throws DAOException {
        Transaction transaction = null;
        
        try (Session session = getSessionFactory().openSession()) {
            Calendar calendar = (Calendar)publication;
            
            transaction = session.beginTransaction();

            Calendar result = session.get(Calendar.class, calendar.getId());
            result.setDescription(calendar.getDescription());
            result.setYear(calendar.getYear());
            result.setPublicationDate(calendar.getPublicationDate());
            result.setTitle(calendar.getTitle());

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
    public void delete(int calendarId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Calendar result = session.get(Calendar.class, calendarId);
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

    @Override
    public Publication[] readAll() throws DAOException {
        return new Publication[0];
    }
}
