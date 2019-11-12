package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.CRUD;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Publication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class PublicationXmlDAO<T extends Publication> implements CRUD<T> {
    private static File xmlDB;
    private final Class<T> type;
    private JAXBContext jaxbContext;

    PublicationXmlDAO(File xmlDB, Class<T> type) {
        PublicationXmlDAO.xmlDB = xmlDB;
        this.type = type;
    }

    @Override
    public void create(T publication) throws DAOException {
        try {
            Publications<T> publications = new Publications<>();
            jaxbContext = JAXBContext.newInstance(type, Publications.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            if (xmlDB.length() != 0)
                publications = (Publications<T>) jaxbUnmarshaller.unmarshal(xmlDB);

            publications.AddPublication(publication);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(publications, xmlDB);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public T read(int id) throws DAOException {
        T result;
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            do {
                result = (T) jaxbUnmarshaller.unmarshal(xmlDB);
            } while (result != null && result.getId() != id);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }

        return result;
    }


    @Override
    public void update(T publication) throws DAOException {

    }

    @Override
    public void delete(int id) throws DAOException {

    }


}
