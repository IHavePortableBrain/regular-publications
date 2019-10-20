package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.CalendarDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.service.api.CalendarService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.CalendarValidator;

public class CalendarServiceImpl implements CalendarService {
    private static final CalendarDAO calendarDAO = DAOFactory.getInstance().getCalendarDAO();

    @Override
    public void create(Calendar calendar) throws ServiceException {
        if (!CalendarValidator.isValidCalendar(calendar)) {
            throw new ServiceException("Invalid calendar: " + calendar);
        }

        try {
            calendarDAO.create(calendar);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Calendar read(int calendarId) throws ServiceException {
        if (!CalendarValidator.isValidId(calendarId)) {
            throw new ServiceException("Invalid calendar id: " + calendarId);
        }

        Calendar calendar;

        try {
            calendar = calendarDAO.read(calendarId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return calendar;
    }

    @Override
    public void update(Calendar calendar) throws ServiceException {
        if (!CalendarValidator.isValidCalendar(calendar)) {
            throw new ServiceException("Invalid calendar: " + calendar);
        }

        try {
            calendarDAO.update(calendar);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int calendarId) throws ServiceException {
        if (!CalendarValidator.isValidId(calendarId)) {
            throw new ServiceException("Invalid calendar id: " + calendarId);
        }

        try {
            calendarDAO.delete(calendarId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
