package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface NewspaperService {
    void create(Newspaper newspaper) throws ServiceException;

    Newspaper read(int newspaperId) throws ServiceException;

    void update(Newspaper newspaper) throws ServiceException;

    void delete(int newspaperId) throws ServiceException;
}
