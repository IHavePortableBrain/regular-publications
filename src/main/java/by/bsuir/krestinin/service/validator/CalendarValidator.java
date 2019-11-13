package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Calendar;

public final class CalendarValidator extends PublicationValidator {
    private static final int MIN_CALENDAR_YEAR = 121;

    public CalendarValidator() {
    }

    private static boolean isValidYear(int year) {
        return year > MIN_CALENDAR_YEAR;
    }

    private static boolean isValidDescription(String description) {
        return description != null && !description.isEmpty();
    }

    public boolean isValid(Calendar calendar) {
        return super.isValid(calendar) &&
                isValidDescription(calendar.getDescription()) &&
                isValidYear(calendar.getYear());
    }
}
