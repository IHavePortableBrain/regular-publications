package by.bsuir.krestinin;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.XmlDAOFactory;
import by.bsuir.krestinin.dao.impl.mysql.*;
import by.bsuir.krestinin.dao.impl.xml.*;
import by.bsuir.krestinin.entity.Publication;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



public class App {
    private static final Logger log = Logger.getLogger(App.class);

    // move migration jar to ../DB
    public static void main(String[] Args) {
        ArrayList<File> validXMLs = new ArrayList<>();

        File dir = new File("DB");
        if (!dir.exists() || !dir.isDirectory())
            return;

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".xml"));
        if (files == null)
            return;

        for (File xmlfile : files) {
            String xsdPath = dir.getPath() + "\\xsd\\" + FilenameUtils.removeExtension(xmlfile.getName()) + ".xsd";
            boolean isValid = validateXMLSchema(xsdPath, xmlfile.getPath());
            String output = xmlfile + (isValid ? " is valid" : " is invalid");
            if (isValid)
                validXMLs.add(xmlfile);
            log.info(output);
        }

        migrateToMySql(validXMLs);
    }

    private static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            log.error("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean migrateToMySql(ArrayList<File> dbFiles) {
        boolean isMigrated = true;
        Publication[] toMigrate;

        AuthorXmlDAO authorXmlDAO = XmlDAOFactory.getInstance().getAuthorDAO();
        AuthorMysqlDAO authorMysqlDAO = new AuthorMysqlDAO();
        if (dbFiles.contains(new File("DB\\author.xml")))
            try {
                toMigrate = authorXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    authorMysqlDAO.create(publication);
                log.info("DB\\author.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\author.xml didn't migrate correctly");
            }

        CatalogXmlDAO catalogXmlDAO = XmlDAOFactory.getInstance().getCatalogDAO();
        CatalogMysqlDAO catalogMysqlDAO = new CatalogMysqlDAO();
        if (dbFiles.contains(new File("DB\\catalog.xml")))
            try {
                toMigrate = catalogXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    catalogMysqlDAO.create(publication);
                log.info("DB\\catalog.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\catalog.xml didn't migrate correctly");
            }

        CalendarXmlDAO calendarXmlDAO = XmlDAOFactory.getInstance().getCalendarDAO();
        CalendarMysqlDAO calendarMysqlDAO = new CalendarMysqlDAO();
        if (dbFiles.contains(new File("DB\\calendar.xml")))
            try {
                toMigrate = calendarXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    calendarMysqlDAO.create(publication);
                log.info("DB\\calendar.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\calendar.xml didn't migrate correctly");
            }

        EventXmlDAO eventXmlDAO = XmlDAOFactory.getInstance().getEventDAO();
        EventMysqlDAO eventMysqlDAO = new EventMysqlDAO();
        if (dbFiles.contains(new File("DB\\event.xml")))
            try {
                toMigrate = eventXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    eventMysqlDAO.create(publication);
                log.info("DB\\event.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\event.xml didn't migrate correctly");
            }

        JournalXmlDAO journalXmlDAO = XmlDAOFactory.getInstance().getJournalDAO();
        JournalMysqlDAO journalMysqlDAO = new JournalMysqlDAO();
        if (dbFiles.contains(new File("DB\\journal.xml")))
            try {
                toMigrate = journalXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    journalMysqlDAO.create(publication);
                log.info("DB\\journal.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\journal.xml didn't migrate correctly");
            }

        NewspaperXmlDAO newspaperXmlDAO = XmlDAOFactory.getInstance().getNewspaperDAO();
        NewspaperMysqlDAO newspaperMysqlDAO = new NewspaperMysqlDAO();
        if (dbFiles.contains(new File("DB\\newspaper.xml")))
            try {
                toMigrate = newspaperXmlDAO.readAll();
                for (Publication publication : toMigrate)
                    newspaperMysqlDAO.create(publication);
                log.info("DB\\newspaper.xml migrated");
            } catch (DAOException e) {
                log.error("DB\\newspaper.xml didn't migrate correctly");
            }

        return isMigrated;
    }
}