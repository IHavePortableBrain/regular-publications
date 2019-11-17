package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.JournalDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Journal;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class JournalMysqlDAO implements JournalDAO {
    @Override
    public void create(Publication journal) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(journal);

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
    public Journal read(int journalId) throws DAOException {
        Transaction transaction = null;

        Journal result;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.get(Journal.class, journalId);

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
            Journal journal = (Journal) publication;

            transaction = session.beginTransaction();

            Journal result = session.get(Journal.class, journal.getId());
            result.setAuthors(journal.getAuthors());
            result.setJournalType(journal.getJournalType());
            result.setPublicationDate(journal.getPublicationDate());
            result.setTitle(journal.getTitle());

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
    public void delete(int journalId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Journal result = session.get(Journal.class, journalId);
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
