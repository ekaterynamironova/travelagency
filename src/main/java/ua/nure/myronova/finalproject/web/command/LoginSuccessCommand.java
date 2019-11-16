package ua.nure.myronova.finalproject.web.command;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.db.entity.User;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.AppException;
import ua.nure.myronova.finalproject.exception.Messages;
import ua.nure.myronova.finalproject.web.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSuccessCommand extends Command {
    private static final long serialVersionUID = 8402701520178705088L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        boolean success = Boolean.parseBoolean(request.getParameter("success"));
        UserServiceImpl userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        String forward = request.getContextPath() + Path.PAGE_LOGIN_PAGE;
        if (success) {
            User user = userService.findUserByLogin(request.getParameter("login"));
            System.out.println("login = " + request.getParameter("login"));
            if (session.getAttribute("user") == null) {
                session.setAttribute("user", user);
            }
            if (UserRole.MANAGER == user.getRole() || UserRole.ADMINISTRATOR == user.getRole()) {
                forward = request.getContextPath() + Path.COMMAND_LIST_USERS;
            } else {
                forward = request.getContextPath() + Path.COMMAND_START;
            }
        } else {
            request.setAttribute("loginError", Messages.ERR_ENTER_CORRECT_LOGINPASS);
        }
        return forward;
    }
}
