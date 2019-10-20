package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Author;

public final class AuthorValidator {
    private static final int MIN_AUTHOR_ID = 0;

    private AuthorValidator() {
    }

    public static boolean isValidAuthor(Author author) {
        return author != null &&
                isValidBiography(author.getBiography()) &&
                isValidBirthPlace(author.getBirthPlace()) &&
                isValidFullName(author.getFullName()) &&
                isValidId(author.getId());
    }

    public static boolean isValidId(int id) {
        return id >= MIN_AUTHOR_ID;
    }

    public static boolean isValidFullName(String fullName) {
        return fullName != null && !fullName.isEmpty();
    }

    public static boolean isValidBirthPlace(String birthPlace) {
        return birthPlace != null && !birthPlace.isEmpty();
    }

    public static boolean isValidBiography(String biography) {
        return biography != null && !biography.isEmpty();
    }
}
