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


public class NewspaperMysqlDAO implements NewspaperDAO {
    @Override
    public void create(Publication newspaper) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(newspaper);

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
    public Newspaper read(int newspaperId) throws DAOException {
        Transaction transaction = null;

        Newspaper result;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.get(Newspaper.class, newspaperId);

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
            Newspaper newspaper = (Newspaper) publication;

            transaction = session.beginTransaction();

            Newspaper result = session.get(Newspaper.class, newspaper.getId());
            result.setEventsDescribed(newspaper.getEventsDescribed());
            result.setPages(newspaper.getPages());
            result.setPublicationDate(newspaper.getPublicationDate());
            result.setTitle(newspaper.getTitle());

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
    public void delete(int newspaperId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Newspaper result = session.get(Newspaper.class, newspaperId);
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
