package ua.nure.myronova.finalproject.web.service;

import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.exception.ServiceException;

import java.util.List;

public interface UserService {

    User findEntityById(Long id) throws ServiceException;

    User findUserByLogin(String login) throws ServiceException;

    List<User> findAllEntities() throws ServiceException;

    boolean delete(Long id) throws ServiceException;

    boolean update(User entity) throws ServiceException;

    boolean register(String login, String password, String role, String email, String name,
                     String surname, String telephone) throws ServiceException;

    boolean loginCheck(String login, String password) throws ServiceException;
}
