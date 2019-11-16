package ua.nure.myronova.finalproject.web.service;

import ua.nure.myronova.finalproject.db.dao.UserDAOImpl;
import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.DAOException;
import ua.nure.myronova.finalproject.exception.UtilException;
import ua.nure.myronova.finalproject.exception.ServiceException;
import ua.nure.myronova.finalproject.exception.Messages;
import ua.nure.myronova.finalproject.util.HashingSHA;
import ua.nure.myronova.finalproject.util.Validator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDAOImpl instance;

    public static synchronized UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public User findEntityById(Long id) throws ServiceException {
        try {
            return getInstance().findEntityById(id);
        } catch (DAOException e) {
            throw new ServiceException(Messages.ERR_CANNOT_FIND_USER_BY_ID, e);
        }
    }

    public User findUserByLogin(String login) throws ServiceException {
        try {
            return getInstance().findUserByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(Messages.ERR_CANNOT_FIND_USER_BY_LOGIN, e);
        }
    }

    @Override
    public List<User> findAllEntities() throws ServiceException {
        try {
            return getInstance().findAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(Messages.ERR_CANNOT_OBTAIN_USERS, e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return getInstance().delete(id);
        } catch (DAOException e) {
            throw new ServiceException(Messages.ERR_CANNOT_DELETE_USER, e);
        }
    }

    @Override
    public boolean update(User entity) throws ServiceException {
        try {
            return getInstance().update(entity);
        } catch (DAOException e) {
            throw new ServiceException(Messages.ERR_CANNOT_DELETE_USER, e);
        }
    }

    public boolean register(String login, String password, String email, String name,
                            String surname, String telephone, String photoURL) throws ServiceException {
        boolean isRegistered = false;
        if (Validator.validateLogin(login)
                && Validator.validatePassword(password)
                && Validator.validateEmail(email)
                && Validator.validateNameOrSurname(name)
                && Validator.validateNameOrSurname(surname)
                && Validator.validateTelephone(telephone)) {
            isRegistered = createUser(login, password, email, name, surname, telephone, photoURL);
        }
        return isRegistered;
    }

    private boolean createUser(String login, String password, String email, String name, String surname,
                               String telephone, String photoURL) throws ServiceException {
        boolean isCreated = false;
        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(HashingSHA.encode(password));
            user.setRole(UserRole.CUSTOMER);
            user.setStatusBlocked(false);
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            user.setTelephone(telephone);
            user.setMoney(0.0);
            if (photoURL != null) {
                URL urlPhoto = getClass().getClassLoader().getResource(photoURL);
                BufferedImage photo = ImageIO.read(urlPhoto);
                File output = new File("../../web/img/users/" + photoURL + ".jpg");
                ImageIO.write(photo, "jpg", output);
                user.setImgPath(output.getAbsolutePath());
            } else {
                File defaultPicture = new File("../../web/img/users/user.jpg");
                user.setImgPath(defaultPicture.getAbsolutePath());
            }
            user.setDiscount(0);
            user.setMaxDiscount(1);
            if (getInstance().create(user)) {
                isCreated = true;
            }
        } catch (IOException | DAOException | UtilException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean loginCheck(String login, String password) throws ServiceException {
        boolean canEnter = false;
        User user;
        try {
            user = getInstance().findUserByLogin(login);
            if (login.equals(user.getLogin())
                    && HashingSHA.encode(password).equals(user.getPassword())
                    && !user.isStatusBlocked()) {
                canEnter = true;
            }
        } catch (DAOException | UtilException e) {
            throw new ServiceException(Messages.ERR_CANNOT_CHECK_LOGIN, e);
        }
        return canEnter;
    }
}
