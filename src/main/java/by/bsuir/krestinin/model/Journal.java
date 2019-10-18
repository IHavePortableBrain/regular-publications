package by.bsuir.krestinin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Journal extends Publication implements Serializable {
    private static final long serialVersionUID = 7618934103472850762L;

    private JournalType journalType;

    public Journal() {
        super();
    }

    public Journal(int id, String title, Date publicationDate, List<Author> authors, JournalType journalType) {
        super(id, title, publicationDate, authors);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Journal journal = (Journal) o;
        return getJournalType() == journal.getJournalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getJournalType());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Journal.class.getSimpleName() + "[", "]")
                .add("journalType=" + journalType)
                .toString();
    }
}
