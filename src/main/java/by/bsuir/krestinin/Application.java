package by.bsuir.krestinin;

import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.*;
import by.bsuir.krestinin.service.api.AuthorService;
import by.bsuir.krestinin.service.api.CalendarService;
import by.bsuir.krestinin.service.api.CatalogService;
import by.bsuir.krestinin.service.api.JournalService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws ServiceException, DAOException {
        demonstrateWork();
    }

    private static void demonstrateWork() throws ServiceException, DAOException {
        CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();
        AuthorService authorService = ServiceFactory.getInstance().getAuthorService();
        JournalService journalService = ServiceFactory.getInstance().getJournalService();
        CatalogService catalogService = ServiceFactory.getInstance().getCatalogService();

        Calendar calendar = new Calendar(4, "title2",
                java.util.Calendar.getInstance().getTime(), 2019, "desc");

        Author author = new Author();
        author.setId(3);
        ArrayList<Integer> authors = new ArrayList<>();
        authors.add(author.getId());

        Journal journal = new Journal(5, "jTitile", java.util.Calendar.getInstance().getTime(),
                authors, JournalType.EVERY_WEEK);

        ArrayList<Integer> journals = new ArrayList<>();
        journals.add(journal.getId());

        author.setPublicationDate(java.util.Calendar.getInstance().getTime());
        author.setTitle("Abraham");
        author.setBiography("bio");
        author.setFullName("FullName");
        author.setBirthPlace("Jaja");
        author.setJournals(journals);

        //demonstrate create
        authorService.create(author);
        calendarService.create(calendar);
        journalService.create(journal);

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
