package by.bsuir.krestinin;

import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.entity.Journal;
import by.bsuir.krestinin.entity.JournalType;
import by.bsuir.krestinin.service.api.AuthorService;
import by.bsuir.krestinin.service.api.CalendarService;
import by.bsuir.krestinin.service.api.JournalService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.factory.ServiceFactory;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws ServiceException {
        demonstrateWork();
    }

    private static void demonstrateWork() throws ServiceException {
        CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();
        AuthorService authorService = ServiceFactory.getInstance().getAuthorService();
        JournalService journalService = ServiceFactory.getInstance().getJournalService();

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

        //final List<Newspaper> newspapersByPagesRange = ServiceFactory.getInstance().getNewspaperService().findNewspapersByPagesRange(10, 15);
        //System.out.println(newspapersByPagesRange);
    }
}
