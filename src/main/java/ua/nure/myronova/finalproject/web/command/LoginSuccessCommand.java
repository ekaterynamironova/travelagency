package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.db.type.UserRole;
import ua.nure.myronova.finalproject.exception.Messages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSuccessCommand extends Command {
    private static final long serialVersionUID = 8402701520178705088L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        boolean success = Boolean.parseBoolean(request.getParameter("success"));
        String role = request.getParameter("role");
        String forward = Path.PAGE_LOGIN_PAGE;
        if (success) {
            if (UserRole.MANAGER.getUserRoleName().equals(role) || UserRole.ADMINISTRATOR.getUserRoleName().equals(role)) {
                forward = Path.COMMAND_LIST_USERS;
            } else {
                forward = Path.COMMAND_START;
            }
        } else {
            request.setAttribute("loginError", Messages.ERR_ENTER_CORRECT_LOGINPASS);
        }
        return forward;
    }
}
