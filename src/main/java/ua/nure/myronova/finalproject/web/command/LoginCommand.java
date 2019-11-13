package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.db.dao.UserDAOImpl;
import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {

    private static final long serialVersionUID = 3134333601163894111L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            throw new AppException("Login/password cannot be empty");
        }

        User user = new UserDAOImpl().findUserByLogin(login);

        if (user == null || !password.equals(user.getPassword())) {
            throw new AppException("Cannot find user with such login/password");
        }

        UserRole userRole = user.getRole();

        String forward = Path.PAGE_ERROR_PAGE;

        if (userRole == UserRole.ADMINISTRATOR) {
            forward = Path.COMMAND_LIST_ORDERS;
        } else if (userRole == UserRole.MANAGER) {
            forward = Path.COMMAND_LIST_MENU;
        } else {
            forward = Path.PAGE_ERROR_PAGE;
        }

        session.setAttribute("user", user);

        session.setAttribute("userRole", userRole);

        return forward;
    }
}
