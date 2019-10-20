package by.bsuir.krestinin.dao.factory;

import by.bsuir.krestinin.dao.api.*;
import by.bsuir.krestinin.dao.impl.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final AuthorDAO authorDAO = new AuthorXmlDAO();
    private final CalendarDAO calendarDAO = new CalendarXmlDAO();
    private final CatalogDAO catalogDAO = new CatalogXmlDAO();
    private final EventDAO eventDAO = new EventXmlDAO();
    private final JournalDAO journalDAO = new JournalXmlDAO();
    private final NewspaperDAO newspaperDAO = new NewspaperXmlDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public CalendarDAO getCalendarDAO() {
        return calendarDAO;
    }

    public CatalogDAO getCatalogDAO() {
        return catalogDAO;
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public JournalDAO getJournalDAO() {
        return journalDAO;
    }

    public NewspaperDAO getNewspaperDAO() {
        return newspaperDAO;
    }
}
