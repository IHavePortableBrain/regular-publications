package by.bsuir.krestinin.dao.factory;

import by.bsuir.krestinin.dao.api.*;
import by.bsuir.krestinin.dao.impl.xml.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class DAOFactory {

    private static final String DB_DIR = "DB";
    private static final DAOFactory instance = new DAOFactory();
    private static final File authorDB = new File(DB_DIR + "\\" + "author.xml");
    private static final File calendarDB = new File(DB_DIR + "\\" + "calendar.xml");
    private static final File catalogDB = new File(DB_DIR + "\\" + "catalog.xml");
    private static final File eventDB = new File(DB_DIR + "\\" + "event.xml");
    private static final File journalDB = new File(DB_DIR + "\\" + "journal.xml");
    private static final File newspaperDB = new File(DB_DIR + "\\" + "newspaper.xml");

    //TODO: change to new xxXmlDao
    private static final AuthorDAO authorDAO = new AuthorXmlDAO(authorDB);
    private static final CalendarDAO calendarDAO = new CalendarXmlDAO(calendarDB);
    private static final CatalogDAO catalogDAO = new CatalogXmlDAO(catalogDB);
    private static final EventDAO eventDAO = new EventXmlDAO(eventDB);
    private static final JournalDAO journalDAO = new JournalXmlDAO(journalDB);
    private static final NewspaperDAO newspaperDAO = new NewspaperXmlDAO(newspaperDB);

    private DAOFactory() {
        if (Files.notExists(Paths.get(DB_DIR)))
            new File(DB_DIR).mkdir();
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
