package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.constants.Fields;
import ua.nure.myronova.finalproject.db.DAOManager;
import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.DAOException;
import ua.nure.myronova.finalproject.exception.Messages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String SQL_CREATE_USER = "INSERT INTO users " +
            "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";

    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";

    private static final String SQL_UPDATE_USER = "UPDATE users " +
            "SET login = ?, password = ?, role = ?, status_blocked = ?, email = ?, name = ?, surname = ?, " +
            "telephone = ?, money = ?, img_path = ?, discount = ?, max_discount = ? " +
            "WHERE id = ?";

    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";

    public static final int PARAMETER_ID_INDEX = 13;

    @Override
    public boolean create(User entity) throws DAOException {
        PreparedStatement stmt = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.prepareStatement(SQL_CREATE_USER);
            prepareStmt(stmt, entity);
            return (stmt.executeUpdate() != 0);
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt);
        }
    }

    private void prepareStmt(PreparedStatement stmt, User entity) throws DAOException {
        try {
            int position = 1;
            stmt.setString(position++, entity.getLogin());
            stmt.setString(position++, entity.getPassword());
            stmt.setString(position++, entity.getRole().getUserRoleName());
            stmt.setBoolean(position++, entity.isStatusBlocked());
            stmt.setString(position++, entity.getEmail());
            stmt.setString(position++, entity.getName());
            stmt.setString(position++, entity.getSurname());
            stmt.setString(position++, entity.getTelephone());
            stmt.setDouble(position++, entity.getMoney());
            stmt.setString(position++, entity.getImgPath());
            stmt.setDouble(position++, entity.getDiscount());
            stmt.setDouble(position, entity.getMaxDiscount());
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_PREPARE_STATEMENT, ex);
        }
    }

    @Override
    public User findEntityById(Long id) throws DAOException {
        User user;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.prepareStatement(SQL_FIND_USER_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            rs.next();
            user = extractUser(rs);
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt, rs);
        }
        return user;
    }

    @Override
    public List<User> findAllEntities() throws DAOException {
        List<User> users = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL_USERS);
            while (rs.next()) {
                users.add(extractUser(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt, rs);
        }
        return users;
    }

    private User extractUser(ResultSet rs) throws DAOException {
        User user = new User();
        try {
            user.setId(rs.getLong(Fields.USER_ID));
            user.setLogin(rs.getString(Fields.USER_LOGIN));
            user.setPassword(rs.getString(Fields.USER_PASSWORD));
            if (UserRole.CUSTOMER.getUserRoleName().equals(rs.getString(Fields.USER_ROLE))) {
                user.setRole(UserRole.CUSTOMER);
            } else if (UserRole.MANAGER.getUserRoleName().equals(rs.getString(Fields.USER_ROLE))) {
                user.setRole(UserRole.MANAGER);
            } else {
                user.setRole(UserRole.ADMINISTRATOR);
            }
            user.setStatusBlocked(rs.getBoolean(Fields.USER_STATUS_BLOCKED));
            user.setEmail(rs.getString(Fields.USER_EMAIL));
            user.setName(rs.getString(Fields.USER_NAME));
            user.setSurname(rs.getString(Fields.USER_SURNAME));
            user.setTelephone(rs.getString(Fields.USER_TELEPHONE));
            user.setMoney(rs.getDouble(Fields.USER_MONEY));
            user.setImgPath(rs.getString(Fields.USER_IMG_PATH));
            user.setDiscount(rs.getDouble(Fields.USER_DISCOUNT));
            user.setMaxDiscount(rs.getDouble(Fields.USER_MAX_DISCOUNT));
            return user;
        } catch (SQLException e) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USER, e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        PreparedStatement stmt = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_USER);
            stmt.setLong(1, id);
            return (stmt.executeUpdate() != 0);
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt);
        }
    }

    @Override
    public boolean update(User entity) throws DAOException {
        PreparedStatement stmt = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_USER);
            stmt.setLong(PARAMETER_ID_INDEX, entity.getId());
            prepareStmt(stmt, entity);
            return (stmt.executeUpdate() != 0);
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt);
        }
    }

    @Override
    public User findUserByLogin(String login) throws DAOException {
        User user;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        DAOManager daoManager = null;
        try {
            daoManager = DAOManager.getInstance();
            con = daoManager.getConnection();
            stmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            rs.next();
            user = extractUser(rs);
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            daoManager.close(con, stmt, rs);
        }
        return user;
    }
}
