package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.EventDAO;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.service.api.EventService;
import by.bsuir.krestinin.service.validator.EventValidator;

public class EventServiceImpl extends PublicationServiceImpl
        implements EventService {
    private static final EventDAO eventDAO = DAOFactory.getInstance().getEventDAO();
    private static final EventValidator eventValidator = new EventValidator();


    @Override
    public EventValidator getValidator() {
        return eventValidator;
    }

    @Override
    public EventDAO getDAO() {
        return eventDAO;
    }

}