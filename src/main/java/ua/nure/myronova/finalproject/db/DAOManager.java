package ua.nure.myronova.finalproject.db;

import ua.nure.myronova.finalproject.exception.DAOException;
import ua.nure.myronova.finalproject.exception.Messages;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DAOManager {

    private static DAOManager instance;

    private DataSource ds;

    public static synchronized DAOManager getInstance() throws DAOException {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }

    private DAOManager() throws DAOException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/travel");
        } catch (NamingException ex) {
            ex.printStackTrace();
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
        }
    }

    public Connection getConnection() throws DAOException {
        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
        }
        return con;
    }

    /**
     * Closes a connection.
     *
     * @param con
     *            Connection to be closed.
     */
    private void close(Connection con) throws DAOException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new DAOException(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
            }
        }
    }

    /**
     * Closes a statement object.
     */
    private void close(Statement stmt) throws DAOException {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new DAOException(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
            }
        }
    }

    /**
     * Closes a result set object.
     */
    private void close(ResultSet rs) throws DAOException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DAOException(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
            }
        }
    }

    /**
     * Closes resources.
     */
    public void close(Connection con, Statement stmt, ResultSet rs) throws DAOException {
        close(rs);
        close(stmt);
        close(con);
    }

    public void close(Connection con, Statement stmt) throws DAOException {
        close(stmt);
        close(con);
    }

    /**
     * Rollbacks a connection.
     *
     * @param con
     *            Connection to be rollbacked.
     */
    public void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
