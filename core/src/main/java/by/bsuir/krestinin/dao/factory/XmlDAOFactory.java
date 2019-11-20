package by.bsuir.krestinin.dao.factory;

import by.bsuir.krestinin.dao.impl.xml.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class XmlDAOFactory {

    private static final String DB_DIR = "DB";
    private static final XmlDAOFactory instance = new XmlDAOFactory();
    private static final File authorDB = new File(DB_DIR + "\\" + "author.xml");
    private static final File calendarDB = new File(DB_DIR + "\\" + "calendar.xml");
    private static final File catalogDB = new File(DB_DIR + "\\" + "catalog.xml");
    private static final File eventDB = new File(DB_DIR + "\\" + "event.xml");
    private static final File journalDB = new File(DB_DIR + "\\" + "journal.xml");
    private static final File newspaperDB = new File(DB_DIR + "\\" + "newspaper.xml");

    private static final AuthorXmlDAO authorDAO = new AuthorXmlDAO(authorDB);
    private static final CalendarXmlDAO calendarDAO = new CalendarXmlDAO(calendarDB);
    private static final CatalogXmlDAO catalogDAO = new CatalogXmlDAO(catalogDB);
    private static final EventXmlDAO eventDAO = new EventXmlDAO(eventDB);
    private static final JournalXmlDAO journalDAO = new JournalXmlDAO(journalDB);
    private static final NewspaperXmlDAO newspaperDAO = new NewspaperXmlDAO(newspaperDB);

    private XmlDAOFactory() {
        if (Files.notExists(Paths.get(DB_DIR)))
            new File(DB_DIR).mkdir();
    }

    public static XmlDAOFactory getInstance() {
        return instance;
    }

    public AuthorXmlDAO getAuthorDAO() {
        return authorDAO;
    }

    public CalendarXmlDAO getCalendarDAO() {
        return calendarDAO;
    }

    public CatalogXmlDAO getCatalogDAO() {
        return catalogDAO;
    }

    public EventXmlDAO getEventDAO() {
        return eventDAO;
    }

    public JournalXmlDAO getJournalDAO() {
        return journalDAO;
    }

    public NewspaperXmlDAO getNewspaperDAO() {
        return newspaperDAO;
    }
}
