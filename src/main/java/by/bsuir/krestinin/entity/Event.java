package by.bsuir.krestinin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class Event implements Serializable {
    private static final long serialVersionUID = -7608861318703624780L;

    private int id;
    private Date dateHappened;
    private String description;
    private int amountOfPeopleActed;

    public Event() {
    }

    public Event(int id, Date dateHappened, String description, int amountOfPeopleActed) {
        this.id = id;
        this.dateHappened = dateHappened;
        this.description = description;
        this.amountOfPeopleActed = amountOfPeopleActed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return id == event.id &&
                getAmountOfPeopleActed() == event.getAmountOfPeopleActed() &&
                getDateHappened().equals(event.getDateHappened()) &&
                getDescription().equals(event.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getDateHappened(), getDescription(), getAmountOfPeopleActed());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dateHappened=" + dateHappened)
                .add("description='" + description + "'")
                .add("amountOfPeopleActed=" + amountOfPeopleActed)
                .toString();
    }
}
