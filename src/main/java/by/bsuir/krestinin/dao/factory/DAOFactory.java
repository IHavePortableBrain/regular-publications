package by.bsuir.krestinin.dao.factory;

import by.bsuir.krestinin.dao.api.*;
import by.bsuir.krestinin.dao.impl.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final AuthorDAO authorDAO = new AuthorMysqlDAO();
    private final CalendarDAO calendarDAO = new CalendarMysqlDAO();
    private final CatalogDAO catalogDAO = new CatalogMysqlDAO();
    private final EventDAO eventDAO = new EventMysqlDAO();
    private final JournalDAO journalDAO = new JournalMysqlDAO();
    private final NewspaperDAO newspaperDAO = new NewspaperMysqlDAO();

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
