package ua.nure.myronova.finalproject.web;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.exception.AppException;
import ua.nure.myronova.finalproject.util.Action;
import ua.nure.myronova.finalproject.web.command.Command;
import ua.nure.myronova.finalproject.web.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1872915617467927430L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response,  Action.FORWARD);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response, Action.REDIRECT);
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response, Action action) throws IOException, ServletException {

        String commandName = request.getParameter("command");
        if (commandName.contains("?")) {
            commandName = commandName.substring(0, commandName.indexOf("?"));
        }
        System.out.println(commandName);
        Command command = CommandContainer.get(commandName);
        String forward = request.getContextPath() + Path.PAGE_ERROR_PAGE;
        try {
            forward = command.execute(request, response);
        } catch (AppException ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", ex.getMessage());
        }
        if(action == Action.REDIRECT) {
            response.sendRedirect(forward);
        } else {
            System.out.println(forward);
            System.out.println(request);
            System.out.println(response);
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }
}
