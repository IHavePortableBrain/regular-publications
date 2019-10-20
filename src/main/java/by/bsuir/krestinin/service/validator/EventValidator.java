package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Event;

import java.util.Date;

public final class EventValidator {

    private static final int MIN_AMOUNT_OF_PEOPLE_ACTED = 0;
    private static final int MIN_EVENT_ID = 0;

    private EventValidator() {
    }

    public static boolean isValidEvent(Event event) {
        return event != null &&
                isValidId(event.getId()) &&
                isValidAmountOfPeopleActed(event.getAmountOfPeopleActed()) &&
                isValidDateHappened(event.getDateHappened()) &&
                isValidDescription(event.getDescription());
    }

    public static boolean isValidId(int id) {
        return id >= MIN_EVENT_ID;
    }

    public static boolean isValidAmountOfPeopleActed(int amountOfPeopleActed) {
        return amountOfPeopleActed > MIN_AMOUNT_OF_PEOPLE_ACTED;
    }

    public static boolean isValidDateHappened(Date dateHappened) {
        return dateHappened != null;
    }

    public static boolean isValidDescription(String description) {
        return description != null && !description.isEmpty();
    }
}
