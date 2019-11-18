package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

import java.util.NoSuchElementException;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;


public class PublicationMysqlDAO implements PublicationDAO {
    @Override
    public void create(Publication publication) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(publication);

            transaction.commit();

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

    Publication setEntityForUpdate(Publication entity, Publication update){
        entity.setPublicationDate(update.getPublicationDate());
        entity.setTitle(update.getTitle());
        return entity;
    }

    @Override
    public void update(Publication publication) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Publication result = session.get(Newspaper.class, publication.getId());
            if (result == null)
                return;
            result = setEntityForUpdate(result, publication);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new DAOException(e);
        }

    }

    @Override
    public void delete(int publicationId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Publication result = session.get(Newspaper.class, publicationId);
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
