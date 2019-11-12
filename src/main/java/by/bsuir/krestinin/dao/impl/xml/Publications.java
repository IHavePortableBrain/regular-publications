package by.bsuir.krestinin.dao.impl.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "publications")
class Publications<T> {
    @XmlElement(name = "publication")
    private ArrayList<T> publications = new ArrayList<>();

    ArrayList<T> getPublications() {
        return publications;
    }

    void setPublications(ArrayList<T> publications) {
        this.publications = publications;
    }

    void AddPublication(T toAdd) {
//        Publication[] old = publications;
//        publications = Arrays.copyOf(old, old.length + 1);
//        publications[publications.length-1] = toAdd;
        publications.add(toAdd);
    }
}
