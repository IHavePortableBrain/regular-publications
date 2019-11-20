package by.bsuir.krestinin;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.*;
import by.bsuir.krestinin.service.api.*;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Application {
    public static void main(String[] args) throws ServiceException, DAOException {
        demonstrateWork();
    }

    private static void demonstrateWork() throws ServiceException, DAOException {
        AuthorService authorService = ServiceFactory.getInstance().getAuthorService();
        CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();
        CatalogService catalogService = ServiceFactory.getInstance().getCatalogService();
        EventService eventService = ServiceFactory.getInstance().getEventService();
        JournalService journalService = ServiceFactory.getInstance().getJournalService();
        NewspaperService newspaperService = ServiceFactory.getInstance().getNewspaperService();


        Calendar calendar = new Calendar(4, "title2",
                java.util.Calendar.getInstance().getTime(), 2019, "desc");

        Author author = new Author();
        author.setId(3);
        ArrayList<Integer> authors = new ArrayList<>();
        authors.add(author.getId());

        Journal journal1 = new Journal(5, "jTitile", java.util.Calendar.getInstance().getTime(),
                authors, JournalType.EVERY_WEEK);

        Journal journal2 = new Journal(6, "j", java.util.Calendar.getInstance().getTime(),
                authors, JournalType.EVERYDAY);

        ArrayList<Integer> journals = new ArrayList<>();
        journals.add(journal1.getId());
        journals.add(journal2.getId());

        author.setPublicationDate(java.util.Calendar.getInstance().getTime());
        author.setTitle("Abraham");
        author.setBiography("bio");
        author.setFullName("FullName");
        author.setBirthPlace("Jaja");
        author.setJournals(journals);

        Author author2 = new Author(7, "ben", "benjin", "was born and is alive",
                new ArrayList<Integer>(0));
        Calendar calendar2 = new Calendar(8, "Special title",
                java.util.Calendar.getInstance().getTime(), 2001,
                "Sweet calendar for sweet guys, and gays as well");
        Newspaper newspaper1 = new Newspaper(9, "Student paper", java.util.Calendar.getInstance().getTime(),
                new ArrayList<Integer>(Arrays.asList(11, 12)), 24);
        Newspaper newspaper2 = new Newspaper(10, "Not Student paper", java.util.Calendar.getInstance().getTime(),
                new ArrayList<Integer>(Collections.emptyList()), 0);
        Event event1 = new Event(11, "No one survived",java.util.Calendar.getInstance().getTime(),
                java.util.Calendar.getInstance().getTime(),
                "behold students - session is coming", 180,
                new ArrayList<Integer>(Collections.singletonList(9)));
        Event event2 = new Event(12, "Yet alive? Get ready for 6th semester",java.util.Calendar.getInstance().getTime(),
                java.util.Calendar.getInstance().getTime(),
                "are u ready?", 42,
                new ArrayList<Integer>(Collections.singletonList(9)));

        //demonstrate create
        authorService.create(author);
        authorService.create(author2);
        calendarService.create(calendar);
        calendarService.create(calendar2);
        journalService.create(journal1);
        journalService.create(journal2);
        newspaperService.create(newspaper1);
        newspaperService.create(newspaper2);
        eventService.create(event1);
        eventService.create(event2);

        //demonstrate update
        calendar.setDescription("New desc");
        calendar.setYear(2048);
        calendar.setId(5);
        calendarService.create(calendar);
        calendar.setYear(2005);
        calendarService.update(calendar);

        //demonstrate read
        System.out.println(calendarService.read(calendar.getId()));

        //demonstrate delete
        calendarService.delete(calendar.getId());
        System.out.println(calendarService.read(calendar.getId()));

        //demonstrate sort
        Catalog cat1 = new Catalog(1, "c", java.util.Calendar.getInstance().getTime(),
                34, 77, "shortDecription1");
        Catalog cat3 = new Catalog(3, "a", java.util.Calendar.getInstance().getTime(),
                2, 2, "shortDecription3");
        Catalog cat2 = new Catalog(2, "b", java.util.Calendar.getInstance().getTime(),
                23, 12, "shortDecription2");
        Catalog[] cats;

        catalogService.create(cat2);
        catalogService.create(cat1);
        catalogService.create(cat3);
        cats = (Catalog[]) catalogService.readAll();
        System.out.println(Arrays.toString(cats));
        System.out.println(catalogService.sortByID(Arrays.asList(cats)));
    }
}
