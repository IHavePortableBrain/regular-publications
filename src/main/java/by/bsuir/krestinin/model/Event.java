package by.bsuir.krestinin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class Event implements Serializable {
    private static final long serialVersionUID = -7608861318703624780L;

    private Date dateHappened;
    private String description;
    private int amountOfPeopleActed;

    public Event() {
    }

    public Event(Date dateHappened, String description, int amountOfPeopleActed) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return getAmountOfPeopleActed() == event.getAmountOfPeopleActed() &&
                getDateHappened().equals(event.getDateHappened()) &&
                getDescription().equals(event.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateHappened(), getDescription(), getAmountOfPeopleActed());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("dateHappened=" + dateHappened)
                .add("description='" + description + "'")
                .add("amountOfPeopleActed=" + amountOfPeopleActed)
                .toString();
    }
}
