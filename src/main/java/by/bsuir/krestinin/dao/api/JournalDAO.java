package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Journal;

public interface JournalDAO {
    void create(Journal journal) throws DAOException;
    Journal read(int journalId) throws DAOException;
    void update(Journal journal) throws DAOException;
    void delete(int journalId) throws DAOException;
}
