package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.exception.ServiceException;

import java.util.List;

public interface NewspaperService {
    void create(Newspaper newspaper) throws ServiceException;

    Newspaper read(int newspaperId) throws ServiceException;

    void update(Newspaper newspaper) throws ServiceException;

    void delete(int newspaperId) throws ServiceException;

    void sortNewspapersByPages(List<Newspaper> newspapers) throws ServiceException;

    void sortNewspapersByTitle(List<Newspaper> newspapers) throws ServiceException;

    List<Newspaper> findNewspapersByPagesRange(int minPages, int maxPages) throws ServiceException;
}
