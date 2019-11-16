package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand extends Command {

    private static final long serialVersionUID = -1339116718168502930L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return Path.COMMAND_START;
    }
}
