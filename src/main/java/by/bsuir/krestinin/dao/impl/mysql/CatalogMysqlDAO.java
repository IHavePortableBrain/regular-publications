package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.CatalogDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Catalog;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class CatalogMysqlDAO implements CatalogDAO {
    @Override
    public void create(Publication catalog) throws DAOException {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(catalog);

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
    public Catalog read(int catalogId) throws DAOException {
        Transaction transaction = null;

        Catalog result;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.get(Catalog.class, catalogId);

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
            Catalog catalog = (Catalog) publication;

            transaction = session.beginTransaction();

            Catalog result = session.get(Catalog.class, catalog.getId());
            result.setAmountOfItems(catalog.getAmountOfItems());
            result.setPrice(catalog.getPrice());
            result.setShortDescription(catalog.getShortDescription());
            result.setPublicationDate(catalog.getPublicationDate());
            result.setTitle(catalog.getTitle());

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
    public void delete(int catalogId) throws DAOException {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Catalog result = session.get(Catalog.class, catalogId);
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
