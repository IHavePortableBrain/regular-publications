package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.CalendarDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Calendar;
import by.bsuir.krestinin.entity.Publication;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static by.bsuir.krestinin.dao.util.HibernateUtil.getSessionFactory;

public class CalendarMysqlDAO  extends PublicationMysqlDAO implements CalendarDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);

        Calendar CalendarEntity = (Calendar)entity;
        Calendar CalendarUpdate = (Calendar)update;

        CalendarEntity.setDescription(CalendarUpdate.getDescription());
        CalendarEntity.setYear(CalendarUpdate.getYear());

        return entity;
    }
}
