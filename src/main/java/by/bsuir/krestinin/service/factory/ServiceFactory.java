package by.bsuir.krestinin.service.factory;


import by.bsuir.krestinin.service.api.*;
import by.bsuir.krestinin.service.impl.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AuthorService authorService = new AuthorServiceImpl();
    private final CalendarService calendarService = new CalendarServiceImpl();
    private final CatalogService catalogService = new CatalogServiceImpl();
    private final EventService eventService = new EventServiceImpl();
    private final JournalService journalService = new JournalServiceImpl();
    private final NewspaperService newspaperService = new NewspaperServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public CalendarService getCalendarService() {
        return calendarService;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public JournalService getJournalService() {
        return journalService;
    }

    public NewspaperService getNewspaperService() {
        return newspaperService;
    }
}
