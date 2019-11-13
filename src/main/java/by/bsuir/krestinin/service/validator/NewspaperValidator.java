package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Event;
import by.bsuir.krestinin.entity.Newspaper;

import java.util.List;

public final class NewspaperValidator extends PublicationValidator {

    private static final int MIN_PAGES = 0;

    public NewspaperValidator() {
    }

    public boolean isValid(Newspaper newspaper) {
        return super.isValid(newspaper) &&
                isValidEventsDescribed(newspaper.getEventsDescribed()) &&
                isValidPageAmount(newspaper.getPages());
    }

    private boolean isValidEventsDescribed(List<Event> events) {
        return events != null;
    }

    private boolean isValidPageAmount(int pageAmount) {
        return pageAmount > MIN_PAGES;
    }
}
