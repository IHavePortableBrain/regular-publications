package by.bsuir.krestinin.dao.factory;

import by.bsuir.krestinin.dao.api.*;
import by.bsuir.krestinin.dao.impl.xml.*;

import java.io.File;
import java.io.IOException;

public final class DAOFactory {

    private static final String XmlPath = "DB.xml";
    private static final File XmlDbFile = new File(XmlPath);
    private static final DAOFactory instance = new DAOFactory(); //must be after XmlDbFile

    //TODO: change to new xxXmlDao
    private final AuthorDAO authorDAO = new AuthorXmlDAO(XmlDbFile);
    private final CalendarDAO calendarDAO = new CalendarXmlDAO(XmlDbFile);
    private final CatalogDAO catalogDAO = new CatalogXmlDAO(XmlDbFile);
    private final EventDAO eventDAO = new EventXmlDAO(XmlDbFile);
    private final JournalDAO journalDAO = new JournalXmlDAO(XmlDbFile);
    private final NewspaperDAO newspaperDAO = new NewspaperXmlDAO(XmlDbFile);

    private DAOFactory() {
        if (!XmlDbFile.exists()) {
            try {
                if (!XmlDbFile.createNewFile())
                    throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
