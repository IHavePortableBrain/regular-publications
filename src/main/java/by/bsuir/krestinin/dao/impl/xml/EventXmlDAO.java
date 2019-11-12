package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.EventDAO;
import by.bsuir.krestinin.entity.Event;

import java.io.File;

public class EventXmlDAO extends PublicationXmlDAO<Event> implements EventDAO {
    public EventXmlDAO(File xmlDB) {
        super(xmlDB, Event.class);
    }
}
