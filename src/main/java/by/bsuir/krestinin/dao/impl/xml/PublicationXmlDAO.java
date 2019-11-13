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
    private File xmlDB;
    private final Class<T> type;
    private JAXBContext jaxbContext;

    PublicationXmlDAO(File xmlDB, Class<T> type) {
        this.xmlDB = xmlDB;
        this.type = type;

        try {
            jaxbContext = JAXBContext.newInstance(type, Publications.class);
        } catch (JAXBException e) {
            e.printStackTrace();
            //handle
        }
    }

    //TODO: creation id check, new file(DB table analog) for each entity
    @Override
    public void create(T publication) throws DAOException {
        try {
            Publications<T> publications = new Publications<>();

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
        T result = null;
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Publications<T> DBcontent = (Publications<T>) jaxbUnmarshaller.unmarshal(xmlDB);
            for (Publication publication : DBcontent.getPublications()
            ) {
                if (publication.getId() == id && publication.getClass() == type) {
                    result = (T) publication;
                    break;
                }
            }
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
