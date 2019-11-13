package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.exception.DAOException;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean create(User entity) throws DAOException {
        return false;
    }

    @Override
    public User findEntityById(Long id) throws DAOException {
        return null;
    }

    @Override
    public List<User> findAllEntities() throws DAOException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return false;
    }

    @Override
    public boolean update(User entity) throws DAOException {
        return false;
    }

    @Override
    public User findUserByLogin(String login) throws DAOException {
        return null;
    }
}
