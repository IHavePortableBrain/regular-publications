package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Author;

public final class AuthorValidator extends PublicationValidator {
    public AuthorValidator() {
    }

    private static boolean isValidFullName(String fullName) {
        return fullName != null && !fullName.isEmpty();
    }

    private static boolean isValidBirthPlace(String birthPlace) {
        return birthPlace != null && !birthPlace.isEmpty();
    }

    private static boolean isValidBiography(String biography) {
        return biography != null && !biography.isEmpty();
    }

    public boolean isValid(Author author) {
        return author != null &&
                super.isValid(author) &&
                isValidBiography(author.getBiography()) &&
                isValidBirthPlace(author.getBirthPlace()) &&
                isValidFullName(author.getFullName());
    }
}
