package by.bsuir.krestinin.service.impl;

import by.bsuir.krestinin.dao.api.NewspaperDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.dao.factory.DAOFactory;
import by.bsuir.krestinin.entity.Newspaper;
import by.bsuir.krestinin.service.api.NewspaperService;
import by.bsuir.krestinin.service.exception.ServiceException;
import by.bsuir.krestinin.service.validator.NewspaperValidator;

public class NewspaperServiceImpl implements NewspaperService {
    private static final NewspaperDAO newspaperDAO = DAOFactory.getInstance().getNewspaperDAO();

    @Override
    public void create(Newspaper newspaper) throws ServiceException {
        if (!NewspaperValidator.isValidNewspaper(newspaper)) {
            throw new ServiceException("Invalid newspaper: " + newspaper);
        }

        try {
            newspaperDAO.create(newspaper);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Newspaper read(int newspaperId) throws ServiceException {
        if (!NewspaperValidator.isValidId(newspaperId)) {
            throw new ServiceException("Invalid newspaper id: " + newspaperId);
        }

        Newspaper newspaper;

        try {
            newspaper = newspaperDAO.read(newspaperId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return newspaper;
    }

    @Override
    public void update(Newspaper newspaper) throws ServiceException {
        if (!NewspaperValidator.isValidNewspaper(newspaper)) {
            throw new ServiceException("Invalid newspaper: " + newspaper);
        }

        try {
            newspaperDAO.update(newspaper);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int newspaperId) throws ServiceException {
        if (!NewspaperValidator.isValidId(newspaperId)) {
            throw new ServiceException("Invalid newspaper id: " + newspaperId);
        }

        try {
            newspaperDAO.delete(newspaperId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
