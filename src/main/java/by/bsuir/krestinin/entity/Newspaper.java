package by.bsuir.krestinin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "newspaper")
public class Newspaper extends Publication implements Serializable {
    private static final long serialVersionUID = -8275022734967734174L;

    @ManyToMany
    @JoinTable(
            name = "newspapers_events",
            joinColumns = @JoinColumn(name = "newspaper_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "events_described")
    private List<Event> eventsDescribed;

    @Column(name = "pages")
    private int pages;

    public Newspaper() {
        super();
    }

    public Newspaper(int id, String title, Date publicationDate, List<Event> eventsDescribed, int pages) {
        super(id, title, publicationDate);

        this.eventsDescribed = eventsDescribed;
        this.pages = pages;
    }

    public List<Event> getEventsDescribed() {
        return eventsDescribed;
    }

    public void setEventsDescribed(List<Event> eventsDescribed) {
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
