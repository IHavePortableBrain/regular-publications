package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface CalendarService {
    void create(Calendar calendar) throws ServiceException;

    Calendar read(int calendarId) throws ServiceException;

    void update(Calendar calendar) throws ServiceException;

    void delete(int calendarId) throws ServiceException;
}
