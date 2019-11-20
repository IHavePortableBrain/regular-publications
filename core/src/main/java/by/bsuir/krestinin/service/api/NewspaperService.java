package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.exception.ServiceException;

import java.util.List;

public interface NewspaperService extends PublicationService {
    void sortNewspapersByPages(List<Newspaper> newspapers) throws ServiceException;

    void sortNewspapersByTitle(List<Newspaper> newspapers) throws ServiceException;
}
