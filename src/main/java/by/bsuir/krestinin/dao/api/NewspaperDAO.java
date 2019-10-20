package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Newspaper;

public interface NewspaperDAO {
    void create(Newspaper newspaper) throws DAOException;
    Newspaper read(int newspaperId) throws DAOException;
    void update(Newspaper newspaper) throws DAOException;
    void delete(int newspaperId) throws DAOException;
}
