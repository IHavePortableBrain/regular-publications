package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.CalendarDAO;
import by.bsuir.krestinin.entity.Calendar;

import java.io.File;

public class CalendarXmlDAO extends PublicationXmlDAO<Calendar> implements CalendarDAO {
    public CalendarXmlDAO(File xmlDB) {
        super(xmlDB, Calendar.class);
    }
}
