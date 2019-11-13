package by.bsuir.krestinin.dao.impl.xml;

import by.bsuir.krestinin.entity.Publication;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "publications")
class Publications {
    @XmlElement(name = "publication")
    private ArrayList<Publication> publications = new ArrayList<>();

    ArrayList<Publication> getPublications() {
        return publications;
    }

    void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    void AddPublication(Publication toAdd) {
//        Publication[] old = publications;
//        publications = Arrays.copyOf(old, old.length + 1);
//        publications[publications.length-1] = toAdd;
        publications.add(toAdd);
    }
}
