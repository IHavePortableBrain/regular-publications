package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Calendar;

public final class CalendarValidator extends PublicationValidator {
    private static final int MIN_CALENDAR_YEAR = 2018;

    private CalendarValidator() {
    }

    public static boolean isValidCalendar(Calendar calendar) {
        return isValidPublication(calendar) &&
                isValidDescription(calendar.getDescription()) &&
                isValidYear(calendar.getYear());
    }

    public static boolean isValidYear(int year) {
        return year > MIN_CALENDAR_YEAR;
    }

    public static boolean isValidDescription(String description) {
        return description != null && !description.isEmpty();
    }
}
