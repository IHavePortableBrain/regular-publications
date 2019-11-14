package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.dao.api.PublicationDAO;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.api.NewspaperService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.NewspaperValidator;
import by.bsuir.krestinin.service.validator.PublicationValidator;

import java.util.Comparator;
import java.util.List;

public class NewspaperServiceImpl extends PublicationServiceImpl
        implements NewspaperService {

    private static final NewspaperDAO newspaperDAO = DAOFactory.getInstance().getNewspaperDAO();
    private static final NewspaperValidator newspaperValidator = new NewspaperValidator();


    @Override
    public PublicationValidator getValidator() {
        return newspaperValidator;
    }

    @Override
    public PublicationDAO getDAO() {
        return newspaperDAO;
    }

    @Override
    public void sortNewspapersByPages(List<Newspaper> newspapers) throws ServiceException {
        if ((newspapers == null)) {
            throw new ServiceException("Newspapers cannot be null!");
        }

        newspapers.sort(Comparator.comparing(Newspaper::getPages).thenComparing(Newspaper::getTitle));
    }

    @Override
    public void sortNewspapersByTitle(List<Newspaper> newspapers) throws ServiceException {
        if ((newspapers == null)) {
            throw new ServiceException("Newspapers cannot be null!");
        }

        newspapers.sort(Comparator.comparing(Newspaper::getTitle).thenComparing(Newspaper::getPages));
    }


}
