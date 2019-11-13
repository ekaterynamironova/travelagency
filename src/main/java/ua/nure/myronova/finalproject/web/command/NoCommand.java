package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCommand extends Command {

    private static final long serialVersionUID = 7603343868211791109L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);

        return Path.PAGE_ERROR_PAGE;
    }
}
