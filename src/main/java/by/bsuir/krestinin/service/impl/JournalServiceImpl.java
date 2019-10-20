package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.JournalDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Journal;
import by.bsuir.krestinin.service.api.JournalService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.JournalValidator;

public class JournalServiceImpl implements JournalService {
    private static final JournalDAO journalDAO = DAOFactory.getInstance().getJournalDAO();

    @Override
    public void create(Journal journal) throws ServiceException {
        if (!JournalValidator.isValidJournal(journal)) {
            throw new ServiceException("Invalid journal: " + journal);
        }

        try {
            journalDAO.create(journal);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Journal read(int journalId) throws ServiceException {
        if (!JournalValidator.isValidId(journalId)) {
            throw new ServiceException("Invalid journal id: " + journalId);
        }

        Journal journal;

        try {
            journal = journalDAO.read(journalId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return journal;
    }

    @Override
    public void update(Journal journal) throws ServiceException {
        if (!JournalValidator.isValidJournal(journal)) {
            throw new ServiceException("Invalid journal: " + journal);
        }

        try {
            journalDAO.update(journal);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int journalId) throws ServiceException {
        if (!JournalValidator.isValidId(journalId)) {
            throw new ServiceException("Invalid journal id: " + journalId);
        }

        try {
            journalDAO.delete(journalId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
