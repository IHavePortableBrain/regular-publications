package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Event;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface EventService {
    void create(Event event) throws ServiceException;
    Event read(int eventId) throws ServiceException;
    void update(Event event) throws ServiceException;
    void delete(int eventId) throws ServiceException;
}
