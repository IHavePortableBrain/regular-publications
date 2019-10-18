package by.bsuir.krestinin.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Publication {
    private int id;
    private String title;
    private Date publicationDate;
    private List<Author> authors;

    public Publication() {
    }

    public Publication(int id, String title, Date publicationDate, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;
        return getId() == that.getId() &&
                getTitle().equals(that.getTitle()) &&
                getPublicationDate().equals(that.getPublicationDate()) &&
                getAuthors().equals(that.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPublicationDate(), getAuthors());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Publication.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("publicationDate=" + publicationDate)
                .add("authors=" + authors)
                .toString();
    }
}
