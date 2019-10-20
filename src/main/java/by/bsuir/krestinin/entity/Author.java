package by.bsuir.krestinin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1659074767148864864L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "biography")
    private String biography;

    @ManyToMany
    @JoinTable(
            name = "authors_journals",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "journal_id"))
    @Column(name = "journals")
    private List<Journal> journals;

    public Author() {
    }

    public Author(int id, String fullName, String birthPlace, String biography, List<Journal> journals) {
        this.id = id;
        this.fullName = fullName;
        this.birthPlace = birthPlace;
        this.biography = biography;
        this.journals = journals;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;

        return getId() == author.getId() &&
                getFullName().equals(author.getFullName()) &&
                getBirthPlace().equals(author.getBirthPlace()) &&
                getBiography().equals(author.getBiography());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getBirthPlace(), getBiography());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("fullName='" + fullName + "'")
                .add("birthPlace='" + birthPlace + "'")
                .add("biography='" + biography + "'")
                .toString();
    }
}
