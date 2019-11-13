package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.db.entity.Entity;
import ua.nure.myronova.finalproject.exception.DAOException;

import java.util.List;

public interface GenericDAO<T extends Entity> {

    boolean create(T entity) throws DAOException;

    T findEntityById(Long id) throws DAOException;

    List<T> findAllEntities() throws DAOException;

    boolean delete(Long id) throws DAOException;

    boolean update(T entity) throws DAOException;
}
