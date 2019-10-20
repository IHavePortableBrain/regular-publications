package by.bsuir.krestinin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "journal")
public class Journal extends Publication implements Serializable {
    private static final long serialVersionUID = 7618934103472850762L;

    @ManyToMany(mappedBy = "journals")
    @Column(name = "authors")
    private List<Author> authors;

    @Column(name = "journal_type")
    @Enumerated(EnumType.STRING)
    private JournalType journalType;

    public Journal() {
        super();
    }

    public Journal(int id, String title, Date publicationDate, List<Author> authors1, JournalType journalType) {
        super(id, title, publicationDate);
        this.authors = authors1;
        this.journalType = journalType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public JournalType getJournalType() {
        return journalType;
    }

    public void setJournalType(JournalType journalType) {
        this.journalType = journalType;
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
        if (!super.equals(o)) return false;
        Journal journal = (Journal) o;

        return authors.equals(journal.authors) &&
                getJournalType() == journal.getJournalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authors, getJournalType());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Journal.class.getSimpleName() + "[", "]")
                .add("authors=" + authors)
                .add("journalType=" + journalType)
                .add(super.toString())
                .toString();
    }
}
