package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Event;
import by.bsuir.krestinin.entity.Newspaper;

import java.util.List;

public final class NewspaperValidator extends PublicationValidator {

    private static final int MIN_PAGES = 0;

    private NewspaperValidator() {
    }

    public static boolean isValidNewspaper(Newspaper newspaper) {
        return isValidPublication(newspaper) &&
                isValidEventsDescribed(newspaper.getEventsDescribed()) &&
                isValidPageAmount(newspaper.getPages());
    }

    public static boolean isValidEventsDescribed(List<Event> events) {
        return events != null;
    }

    public static boolean isValidPageAmount(int pageAmount) {
        return pageAmount > MIN_PAGES;
    }
}
