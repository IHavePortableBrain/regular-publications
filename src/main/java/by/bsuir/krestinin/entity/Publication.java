package by.bsuir.krestinin.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@MappedSuperclass
public abstract class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_date")
    private Date publicationDate;

    public Publication() {
    }

    public Publication(int id, String title, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;
        return getId() == that.getId() &&
                getTitle().equals(that.getTitle()) &&
                getPublicationDate().equals(that.getPublicationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPublicationDate());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Publication.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("publicationDate=" + publicationDate)
                .toString();
    }
}
