package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.entity.Newspaper;

import java.io.File;
import java.util.List;

public class NewspaperXmlDAO extends PublicationXmlDAO implements NewspaperDAO {
    public NewspaperXmlDAO(File xmlDB) {
        super(xmlDB, Newspaper.class);
    }

    @Override
    public List<Newspaper> findNewspapersByPagesRange(int minPages, int maxPages) {
        return null;
    }
}
