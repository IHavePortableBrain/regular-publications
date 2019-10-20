package by.bsuir.krestinin.dao.api;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Calendar;

public interface CalendarDAO {
    void create(Calendar calendar) throws DAOException;

    Calendar read(int calendarId) throws DAOException;

    void update(Calendar calendar) throws DAOException;

    void delete(int calendarId) throws DAOException;
}
