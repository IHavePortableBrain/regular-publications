package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.CalendarDAO;
import by.bsuir.krestinin.dao.factory.XmlDAOFactory;
import by.bsuir.krestinin.service.api.CalendarService;
import by.bsuir.krestinin.service.validator.CalendarValidator;

public class CalendarServiceImpl extends PublicationServiceImpl
        implements CalendarService {
    private static final CalendarDAO calendarDAO = XmlDAOFactory.getInstance().getCalendarDAO();
    private static final CalendarValidator catalogValidator = new CalendarValidator();

    @Override
    public CalendarValidator getValidator() {
        return catalogValidator;
    }

    @Override
    public CalendarDAO getDAO() {
        return calendarDAO;
    }
}
