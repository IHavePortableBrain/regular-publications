package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Event;

import java.util.Date;

public final class EventValidator extends PublicationValidator {

    private static final int MIN_AMOUNT_OF_PEOPLE_ACTED = 0;

    public EventValidator() {
    }

    private static boolean isValidAmountOfPeopleActed(int amountOfPeopleActed) {
        return amountOfPeopleActed > MIN_AMOUNT_OF_PEOPLE_ACTED;
    }

    private static boolean isValidDateHappened(Date dateHappened) {
        return dateHappened != null;
    }

    private static boolean isValidDescription(String description) {
        return description != null && !description.isEmpty();
    }

    public boolean isValid(Event event) {
        return event != null &&
                super.isValid(event) &&
                isValidId(event.getId()) &&
                isValidAmountOfPeopleActed(event.getAmountOfPeopleActed()) &&
                isValidDateHappened(event.getDateHappened()) &&
                isValidDescription(event.getDescription());
    }
}
