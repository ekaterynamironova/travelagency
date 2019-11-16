package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.exception.AppException;
import ua.nure.myronova.finalproject.exception.CommandException;
import ua.nure.myronova.finalproject.exception.Messages;
import ua.nure.myronova.finalproject.exception.ServiceException;
import ua.nure.myronova.finalproject.web.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand extends Command {

    private static final long serialVersionUID = 2906880978201765715L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String photoURL = request.getParameter("img");

        UserServiceImpl userService = new UserServiceImpl();
        String forward = Path.PAGE_REGISTER_PAGE;
        try {
            if (userService.register(login, password, email, name, surname, telephone, photoURL)) {
                forward = Path.COMMAND_ACCOUNT;
            }
        } catch (ServiceException e) {
            throw new CommandException(Messages.ERR_CANNOT_CREATE_USER, e);
        }
        return forward;
    }
}
