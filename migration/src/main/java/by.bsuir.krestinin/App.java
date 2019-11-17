package by.bsuir.krestinin;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.XmlDAOFactory;
import by.bsuir.krestinin.dao.impl.mysql.CalendarMysqlDAO;
import by.bsuir.krestinin.dao.impl.xml.AuthorXmlDAO;
import by.bsuir.krestinin.dao.impl.xml.CalendarXmlDAO;
import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.entity.Publication;
import org.apache.commons.io.FilenameUtils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class App{
    // move migration jar to ../DB
    public static void main(String[] Args){ //TODO: change to args
        String[] args = { "DB" }; //for debug
        ArrayList<File> validXMLs = new ArrayList<>();
        System.out.println(Arrays.toString(args));
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        File dir = new File(args[0]);
        if (!dir.exists() || !dir.isDirectory())
            return;

        File [] files = dir.listFiles((dir1, name) -> name.endsWith(".xml"));
        if (files == null)
            return;

        for (File xmlfile : files) {
            String xsdPath = dir.getPath() + "\\xsd\\" + FilenameUtils.removeExtension(xmlfile.getName()) + ".xsd";
            boolean isValid = validateXMLSchema(xsdPath, xmlfile.getPath());
            String output = xmlfile + (isValid? " is valid": " is invalid");
            if (isValid)
                validXMLs.add(xmlfile);
            System.out.println(output);
        }

        migrateToMySql(validXMLs);
        //TODO: validate each bd file, migrate to mySql
    }

    private static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean migrateToMySql(ArrayList<File> dbFiles){
        boolean isMigrated = true;
        Publication[] toMigrate;

        AuthorXmlDAO authorXmlDAO = XmlDAOFactory.getInstance().getAuthorDAO();
        if (dbFiles.contains(new File("DB\\author.xml")))
            try {
                toMigrate = authorXmlDAO.readAll();
            }catch (DAOException e){

            }

        CalendarXmlDAO calendarXmlDAO = XmlDAOFactory.getInstance().getCalendarDAO();
        CalendarMysqlDAO calendarMysqlDAO = new CalendarMysqlDAO();
        if (dbFiles.contains(new File("DB\\calendar.xml")))
            try {
                toMigrate = calendarXmlDAO.readAll();
                calendarMysqlDAO.create(toMigrate[0]);
            }catch (DAOException e){

            }


        return isMigrated;
    }
}