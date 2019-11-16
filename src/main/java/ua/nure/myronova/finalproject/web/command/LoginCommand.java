package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.CommandException;
import ua.nure.myronova.finalproject.exception.Messages;
import ua.nure.myronova.finalproject.exception.ServiceException;
import ua.nure.myronova.finalproject.web.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {

    private static final long serialVersionUID = 3134333601163894111L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        boolean success = false;
        String forward = request.getContextPath() + Path.COMMAND_LOGIN_SUCCESS;
        try {
            if (userService.loginCheck(login, password)) {
                User user = userService.findUserByLogin(login);
                HttpSession session = request.getSession();
                if (session.getAttribute("user") == null) {
                    session.setAttribute("user", user);
                }
                success = true;
                forward += "&role=" + user.getRole();
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return forward + "&success=" + success;
    }
}
