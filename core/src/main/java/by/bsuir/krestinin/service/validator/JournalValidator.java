package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Journal;

public final class JournalValidator extends PublicationValidator {
    public JournalValidator() {
    }

    public boolean isValid(Journal journal) {
        return super.isValid(journal) &&
                isValidJournalType(journal);
    }

    private boolean isValidJournalType(Journal journal) {
        return journal.getJournalType() != null;
    }
}
