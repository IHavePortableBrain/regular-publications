package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Publication;

public class PublicationValidator {
    private static final int MIN_PUBLICATION_ID = 0;

    protected PublicationValidator() {
    }

    public static boolean isValidPublication(Publication publication) {
        return publication != null &&
                isValidId(publication.getId()) &&
                isValidTitle(publication.getTitle());
    }

    public static boolean isValidId(int id) {
        return id >= MIN_PUBLICATION_ID;
    }

    public static boolean isValidTitle(String title) {
        return title != null && !title.isEmpty();
    }
}
