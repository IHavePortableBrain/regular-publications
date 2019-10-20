package by.bsuir.krestinin.service.api;

import by.bsuir.krestinin.entity.Journal;
import by.bsuir.krestinin.service.exception.ServiceException;

public interface JournalService {
    void create(Journal journal) throws ServiceException;
    Journal read(int journalId) throws ServiceException;
    void update(Journal journal) throws ServiceException;
    void delete(int journalId) throws ServiceException;
}
