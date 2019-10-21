package by.bsuir.krestinin;

import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.api.CalendarService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.factory.ServiceFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) throws ServiceException {
        demonstrateWork();
    }

    private static void demonstrateWork() throws ServiceException {
        CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();
        Calendar calendar = new Calendar();
        calendar.setTitle("Title");
        calendar.setPublicationDate(java.util.Calendar.getInstance().getTime());
        calendar.setYear(2019);
        calendar.setDescription("desc");

        calendarService.create(calendar);

        calendar.setDescription("new desc");

        calendarService.update(calendar);

        System.out.println(calendarService.read(calendar.getId()));

        calendarService.delete(calendar.getId());

        final List<Newspaper> newspapersByPagesRange = ServiceFactory.getInstance().getNewspaperService().findNewspapersByPagesRange(10, 15);
        System.out.println(newspapersByPagesRange);
    }
}
