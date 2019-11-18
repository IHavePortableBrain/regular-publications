package by.bsuir.krestinin.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "newspaper")
@XmlRootElement(name = "newspaper")
public class Newspaper extends Publication implements Serializable {
    private static final long serialVersionUID = -8275022734967734174L;

    @ElementCollection
    @Column(name = "events_described")
    private List<Integer> eventsDescribed; //List<Event>

    @Column(name = "pages")
    private int pages;

    public Newspaper() {
        super();
    }

    public Newspaper(int id, String title, Date publicationDate, ArrayList<Integer> eventsDescribed, int pages) {
        super(id, title, publicationDate);

        this.eventsDescribed = eventsDescribed;
        this.pages = pages;
    }

    public List<Integer> getEventsDescribed() {
        return eventsDescribed;
    }

    public void setEventsDescribed(List<Integer> eventsDescribed) {
        this.eventsDescribed = eventsDescribed;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;
        return getPages() == newspaper.getPages() &&
                getEventsDescribed().equals(newspaper.getEventsDescribed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEventsDescribed(), getPages());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Newspaper.class.getSimpleName() + "[", "]")
                .add("eventsDescribed=" + eventsDescribed)
                .add("pages=" + pages)
                .add(super.toString())
                .toString();
    }
}
