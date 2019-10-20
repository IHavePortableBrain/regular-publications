package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Event;

public interface EventDAO {
    void create(Event event) throws DAOException;

    Event read(int eventId) throws DAOException;

    void update(Event event) throws DAOException;

    void delete(int eventId) throws DAOException;
}
