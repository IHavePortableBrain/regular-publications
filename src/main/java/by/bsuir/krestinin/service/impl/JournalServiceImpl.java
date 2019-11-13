package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.JournalDAO;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.service.api.JournalService;
import by.bsuir.krestinin.service.validator.JournalValidator;

//TODO: rewrite services like Dao layer
public class JournalServiceImpl extends PublicationServiceImpl
        implements JournalService {
    private static final JournalDAO journalDAO = DAOFactory.getInstance().getJournalDAO();
    private static final JournalValidator journalValidator = new JournalValidator();


    @Override
    public JournalValidator getValidator() {
        return journalValidator;
    }

    @Override
    public JournalDAO getDAO() {
        return journalDAO;
    }

}
