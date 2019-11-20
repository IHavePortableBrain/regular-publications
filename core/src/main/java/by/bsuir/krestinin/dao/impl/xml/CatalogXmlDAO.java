package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.CatalogDAO;
import by.bsuir.krestinin.entity.Catalog;

import java.io.File;

public class CatalogXmlDAO extends PublicationXmlDAO implements CatalogDAO {
    public CatalogXmlDAO(File xmlDB) {
        super(xmlDB, Catalog.class);
    }
}
