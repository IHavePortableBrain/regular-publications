package by.bsuir.krestinin.dao.impl.mysql;

import by.bsuir.krestinin.dao.api.AuthorDAO;
import by.bsuir.krestinin.dao.exception.DAOException;
import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.entity.Publication;
import by.bsuir.krestinin.service.exception.ServiceException;

public class AuthorMysqlDAO extends PublicationMysqlDAO implements AuthorDAO {
    @Override
    Publication setEntityForUpdate(Publication entity, Publication update){
        entity = super.setEntityForUpdate(entity, update);

        Author AuthorEntity = (Author)entity;
        Author AuthorUpdate = (Author)update;

        AuthorEntity.setBirthPlace(AuthorUpdate.getBirthPlace());
        AuthorEntity.setFullName(AuthorUpdate.getFullName());
        AuthorEntity.setBiography(AuthorUpdate.getBiography());
        AuthorEntity.setJournals(AuthorUpdate.getJournals());

        return entity;
    }
}
