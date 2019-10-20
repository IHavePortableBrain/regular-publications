package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.EventDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Event;
import by.bsuir.krestinin.service.api.EventService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.EventValidator;

public class EventServiceImpl implements EventService {
    private static final EventDAO eventDAO = DAOFactory.getInstance().getEventDAO();

    @Override
    public void create(Event event) throws ServiceException {
        if (!EventValidator.isValidEvent(event)) {
            throw new ServiceException("Invalid event: " + event);
        }

        try {
            eventDAO.create(event);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Event read(int eventId) throws ServiceException {
        if (!EventValidator.isValidId(eventId)) {
            throw new ServiceException("Invalid event id: " + eventId);
        }

        Event event;

        try {
            event = eventDAO.read(eventId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return event;
    }

    @Override
    public void update(Event event) throws ServiceException {
        if (!EventValidator.isValidEvent(event)) {
            throw new ServiceException("Invalid event: " + event);
        }

        try {
            eventDAO.update(event);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int eventId) throws ServiceException {
        if (!EventValidator.isValidId(eventId)) {
            throw new ServiceException("Invalid event id: " + eventId);
        }

        try {
            eventDAO.delete(eventId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
