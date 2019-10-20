package by.bsuir.krestinin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Calendar extends Publication implements Serializable {
    private static final long serialVersionUID = -2995839918904085318L;

    private int year;
    private String description;

    public Calendar() {
        super();
    }

    public Calendar(int id, String title, Date publicationDate, List<Author> authors, int year, String description) {
        super(id, title, publicationDate, authors);
        this.year = year;
        this.description = description;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Calendar calendar = (Calendar) o;
        return getYear() == calendar.getYear() &&
                getDescription().equals(calendar.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getYear(), getDescription());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Calendar.class.getSimpleName() + "[", "]")
                .add("year=" + year)
                .add("description='" + description + "'")
                .toString();
    }
}
