package by.bsuir.krestinin.dao.impl;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Newspaper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

@org.hibernate.annotations.NamedNativeQueries({
        @org.hibernate.annotations.NamedNativeQuery(
                name = "Newspaper_FoundByMinMaxPages",
                query = "SELECT * FROM newspaper n WHERE n.pages BETWEEN :min AND :max;",
                resultClass = Newspaper.class
        )
})
public class NewspaperMysqlDAO implements NewspaperDAO {

    private static final String NEWSPAPER_FIND_BY_PAGES_RANGE = "SELECT * FROM newspaper n WHERE n.pages BETWEEN :min AND :max";

    @Override
    public void create(Newspaper newspaper) throws DAOException {
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
    public void update(Newspaper newspaper) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
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
    public List<Newspaper> findNewspapersByPagesRange(int minPages, int maxPages) throws DAOException {
        List<Newspaper> result;

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Newspaper> query = session.createNativeQuery(NEWSPAPER_FIND_BY_PAGES_RANGE, Newspaper.class);

            query.setParameter("min", minPages);
            query.setParameter("max", maxPages);

            result = query.getResultList();
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
}
