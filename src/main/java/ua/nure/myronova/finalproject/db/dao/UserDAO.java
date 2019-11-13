package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.exception.DAOException;

public interface UserDAO extends GenericDAO<User> {

    User findUserByLogin(String login) throws DAOException;
}
