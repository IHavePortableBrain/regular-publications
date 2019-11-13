package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.entity.Author;

import java.io.File;

public class AuthorXmlDAO extends PublicationXmlDAO implements AuthorDAO {
    public AuthorXmlDAO(File xmlDB) {
        super(xmlDB, Author.class);
    }
}
