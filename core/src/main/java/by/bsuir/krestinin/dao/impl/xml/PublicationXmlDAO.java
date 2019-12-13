package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Publication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class PublicationXmlDAO implements PublicationDAO {
    private File xmlDB;
    private final Class type;
    private JAXBContext jaxbContext;

    PublicationXmlDAO(File xmlDB, Class type) {
        this.xmlDB = xmlDB;
        this.type = type;

        try {
            jaxbContext = JAXBContext.newInstance(type, Publications.class);
        } catch (JAXBException e) {
            e.printStackTrace();
            //handle
        }
    }

    //TODO: creation id check
    @Override
    public void create(Publication publication) throws DAOException {
        try {
            Publications publications = new Publications();

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            if (xmlDB.length() != 0)
                publications = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);

            publications.AddPublication(publication);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(publications, xmlDB);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Publication read(int id) throws DAOException {
        Publication result = null;
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Publications DBcontent = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);
            for (Publication publication : DBcontent.getPublications()
            ) {
                if (publication.getId() == id) {
                    result = publication;
                    break;
                }
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }

        return result;
    }

    public Publication[] readAll() throws DAOException {
        Publication[] result = (Publication[]) java.lang.reflect.Array.newInstance(type, 0);
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Publications DBcontent = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);
            result = DBcontent.getPublications().toArray(result);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }

        return result;
    }

    public Publication[] readAll(File xmlDB) throws DAOException {
        Publication[] result = (Publication[]) java.lang.reflect.Array.newInstance(type, 0);
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Publications DBcontent = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);
            result = DBcontent.getPublications().toArray(result);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }

        return result;
    }

    @Override
    public void update(Publication publication) throws DAOException {
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            if (xmlDB.length() == 0)
                return;
            Publications publications = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);

            Publication[] old = (Publication[]) java.lang.reflect.Array.newInstance(type, 0);
            old = publications.getPublications().toArray(old);
            for (int i = 0; i < old.length; i++) {
                if (old[i].getId() == publication.getId()) {
                    old[i] = publication;
                    break;
                }
            }

            publications.setPublications(new ArrayList(Arrays.asList(old)));

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(publications, xmlDB);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            if (xmlDB.length() == 0)
                return;
            Publications publications = (Publications) jaxbUnmarshaller.unmarshal(xmlDB);

            Publication[] old = (Publication[]) java.lang.reflect.Array.newInstance(type, 0);
            old = publications.getPublications().toArray(old);
            for (int i = 0; i < old.length; i++) {
                if (old[i].getId() == id) {
                    old = removeTheElement(old, i);
                    break;
                }
            }

            publications.setPublications(new ArrayList(Arrays.asList(old)));

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(publications, xmlDB);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    //TODO: derive into array extension
    private Publication[] removeTheElement(Publication[] arr, int index) {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        Publication[] anotherArray = (Publication[]) java.lang.reflect.Array.newInstance(type, arr.length - 1);

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }
}
