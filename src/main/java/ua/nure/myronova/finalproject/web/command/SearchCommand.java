package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCommand extends Command {

    private static final long serialVersionUID = 8165851759889793054L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        return Path.PAGE_HOME_PAGE;
    }
}
