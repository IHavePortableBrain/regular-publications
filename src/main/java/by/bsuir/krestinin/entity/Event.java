package by.bsuir.krestinin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "event")
public class Event implements Serializable {
    private static final long serialVersionUID = -7608861318703624780L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date_mapped")
    private Date dateHappened;

    @Column(name = "description")
    private String description;

    @Column(name = "amount_of_people_acted")
    private int amountOfPeopleActed;

    @ManyToMany(mappedBy = "eventsDescribed")
    @Column(name = "publishing_places")
    private List<Newspaper> publishingPlaces;

    public Event() {
    }

    public Event(int id, Date dateHappened, String description, int amountOfPeopleActed, List<Newspaper> publishingPlaces) {
        this.id = id;
        this.dateHappened = dateHappened;
        this.description = description;
        this.amountOfPeopleActed = amountOfPeopleActed;
        this.publishingPlaces = publishingPlaces;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getDateHappened() {
        return dateHappened;
    }

    public void setDateHappened(Date dateHappened) {
        this.dateHappened = dateHappened;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountOfPeopleActed() {
        return amountOfPeopleActed;
    }

    public void setAmountOfPeopleActed(int amountOfPeopleActed) {
        this.amountOfPeopleActed = amountOfPeopleActed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Newspaper> getPublishingPlaces() {
        return publishingPlaces;
    }

    public void setPublishingPlaces(List<Newspaper> publishingPlaces) {
        this.publishingPlaces = publishingPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId() &&
                getAmountOfPeopleActed() == event.getAmountOfPeopleActed() &&
                getDateHappened().equals(event.getDateHappened()) &&
                getDescription().equals(event.getDescription()) &&
                getPublishingPlaces().equals(event.getPublishingPlaces());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateHappened(), getDescription(), getAmountOfPeopleActed(), getPublishingPlaces());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dateHappened=" + dateHappened)
                .add("description='" + description + "'")
                .add("amountOfPeopleActed=" + amountOfPeopleActed)
                .add("publishingPlaces=" + publishingPlaces)
                .toString();
    }
}
