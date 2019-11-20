package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.entity.Newspaper;

import java.io.File;

public class NewspaperXmlDAO extends PublicationXmlDAO implements NewspaperDAO {
    public NewspaperXmlDAO(File xmlDB) {
        super(xmlDB, Newspaper.class);
    }
}
