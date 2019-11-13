package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.JournalDAO;
import by.bsuir.krestinin.entity.Journal;

import java.io.File;

public class JournalXmlDAO extends PublicationXmlDAO implements JournalDAO {
    public JournalXmlDAO(File xmlDB) {
        super(xmlDB, Journal.class);
    }
}
