package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Journal;

public final class JournalValidator extends PublicationValidator{
    private JournalValidator(){
    }

    public static boolean isValidJournal(Journal journal) {
        return isValidPublication(journal) &&
                isValidJournalType(journal);
    }

    public static boolean isValidJournalType(Journal journal) {
        return journal.getJournalType() != null;
    }
}
