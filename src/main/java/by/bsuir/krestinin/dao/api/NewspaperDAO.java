package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Newspaper;

import java.util.List;

public interface NewspaperDAO extends PublicationDAO {
    List<Newspaper> findNewspapersByPagesRange(int minPages, int maxPages) throws DAOException;
}
